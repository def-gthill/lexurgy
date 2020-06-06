package com.meamoria.lexurgy

import com.github.ajalt.clikt.output.TermUi.echo
import com.sun.jna.Native
import com.sun.jna.Platform
import com.sun.jna.Pointer
import com.sun.jna.platform.win32.Kernel32
import com.sun.jna.platform.win32.WinNT
import com.sun.jna.ptr.IntByReference
import java.io.IOException
import java.nio.file.Path

fun console(message: String) = DebugLogger.debugEcho(message)

fun debug(message: String) {
    DebugLogger.debugEcho(message)
    DebugLogger.getPath().toFile().appendText(message + System.lineSeparator())
}

object DebugLogger {
    private lateinit var debugFilePath: Path

    fun getPath(): Path = debugFilePath

    fun setPath(value: Path) {
        debugFilePath = value
        try {
            debugFilePath.toFile().delete()
        } catch (e: IOException) {
            // Swallow this and keep going
        }
    }

    val debugFilePathIsInitialized
        get() = this::debugFilePath.isInitialized

    fun debugEcho(message: String) {
        debugPrinter.print(message)
    }

    private val debugPrinter: DebugPrinter =
        if (Platform.isWindows()) WindowsPrinter() else RegularPrinter()

    private interface DebugPrinter {
        fun print(message: String)
    }

    private class RegularPrinter : DebugPrinter {
        override fun print(message: String) = echo(message)
    }

    // Uses the WriteConsoleW system call to force the console to display Unicode.
    private class WindowsPrinter : DebugPrinter {

        private val kernel: KernelWithUnicode = Native.load("Kernel32", KernelWithUnicode::class.java)
        private val consoleHandle: WinNT.HANDLE = kernel.GetStdHandle(Kernel32.STD_OUTPUT_HANDLE)

        override fun print(message: String) {
            val mode = IntByReference()
            if (kernel.GetConsoleMode(consoleHandle, mode)) {
                val chars = (message + System.lineSeparator()).toCharArray()
                if (!kernel.WriteConsoleW(consoleHandle.pointer, chars, chars.size, IntByReference(), null)) {
                    echo(message)
                }
            } else {
                echo(message)
            }
        }
    }

    private interface KernelWithUnicode : Kernel32 {
        @Suppress("FunctionName")
        fun WriteConsoleW(
            hConsoleOutput: Pointer?,
            lpBuffer: CharArray?,
            nNumberOfCharsToWrite: Int,
            lpNumberOfCharsWritten: IntByReference?,
            lpReserved: Pointer?
        ): Boolean
    }
}

/**
 * Puts the number in front of the word, with the word correctly marked for singular/plural.
 * For example:
 *
 * - ``enpl(1, "cat")`` yields ``"1 cat"``.
 * - ``enpl(3, "cat")`` yields ``"3 cats"``.
 * - ``enpl(3, "box")`` yields ``"3 boxs"``; use the ``plural`` argument to specify the plural manually.
 * - ``enpl(3, "box", "boxes")`` correctly yields ``"3 boxes"``.
 */
fun enpl(number: Int, word: String, plural: String? = null): String {
    val form = if (number == 1) word else plural ?: word + "s"
    return "$number $form"
}