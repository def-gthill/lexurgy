package com.meamoria.lexurgy

import com.sun.jna.Pointer
import com.sun.jna.WString
import com.sun.jna.platform.win32.Kernel32
import com.sun.jna.platform.win32.Shell32
import com.sun.jna.ptr.IntByReference

@Suppress("FunctionName")
internal interface KernelWithUnicode : Kernel32 {
    fun WriteConsoleW(
        hConsoleOutput: Pointer?,
        lpBuffer: CharArray?,
        nNumberOfCharsToWrite: Int,
        lpNumberOfCharsWritten: IntByReference?,
        lpReserved: Pointer?
    ): Boolean

    fun GetCommandLineW(): WString?
}

@Suppress("FunctionName")
internal interface Shell32WithUnicode : Shell32 {
    fun CommandLineToArgvW(
        lpCmdLine: WString?,
        pNumArgs: IntByReference?
    ): Pointer?
}
