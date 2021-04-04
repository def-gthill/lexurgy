package com.meamoria.lexurgy

import kotlin.js.RegExp

actual fun String.combiningCount(): Int =
    try {
        count { RegExp("\\p{Mn}", flags = "u").test(it.toString()) }
    } catch (e: Throwable) {
        // Fallback for old browsers
        0
    }

actual fun String.normalizeDecompose(): String = asDynamic().normalize("NFD") as String

actual fun String.normalizeCompose(): String = asDynamic().normalize("NFC") as String
