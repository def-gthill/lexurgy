package com.meamoria.lexurgy

import kotlin.js.RegExp

actual fun String.combiningCount(): Int =
    try {
        count { RegExp("\\p{Mn}", flags = "u").test(it.toString()) }
    } catch (e: Throwable) {
        // Fallback for old browsers
        0
    }
