package com.meamoria.lexurgy.cli

import com.sun.jna.Native
import com.sun.jna.Platform
import com.sun.jna.platform.win32.Kernel32
import com.sun.jna.platform.win32.WinNT
import com.sun.jna.ptr.IntByReference

fun getArgs(sysArgs: Array<String>): Array<String> =
    UnicodeArgumentGetter.getUnicodeArgs(sysArgs)

object UnicodeArgumentGetter {
    fun getUnicodeArgs(sysArgs: Array<String>): Array<String> =
        argumentGetter.getArgs(sysArgs)

    private val argumentGetter: ArgumentGetter =
        if (Platform.isWindows()) WindowsArgumentGetter() else RegularGetter()

    private interface ArgumentGetter {
        fun getArgs(sysArgs: Array<String>): Array<String>
    }

    private class RegularGetter : ArgumentGetter {
        override fun getArgs(sysArgs: Array<String>): Array<String> = sysArgs
    }

    private class WindowsArgumentGetter : ArgumentGetter {

        private val kernel: KernelWithUnicode = Native.load("Kernel32", KernelWithUnicode::class.java)
        private val shellapi: Shell32WithUnicode = Native.load("Shell32", Shell32WithUnicode::class.java)
        private val consoleHandle: WinNT.HANDLE = kernel.GetStdHandle(Kernel32.STD_OUTPUT_HANDLE)

        override fun getArgs(sysArgs: Array<String>): Array<String> {
            val mode = IntByReference()
            if (kernel.GetConsoleMode(consoleHandle, mode)) {
                val argsLine = kernel.GetCommandLineW() ?: return sysArgs
                val argsLength = IntByReference()
                val argsPointer = shellapi.CommandLineToArgvW(argsLine, argsLength) ?: return sysArgs
                val args = argsPointer.getWideStringArray(0, argsLength.value)
                return args.dropWhile { !it.startsWith("com.meamoria.lexurgy") }.drop(1).toTypedArray()
            } else {
                return sysArgs
            }
        }
    }
}
