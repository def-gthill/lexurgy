package com.meamoria.lexurgy

import java.nio.file.Path

fun <K, V> MutableMap<K, V>.setdefault(key: K, newValue: V): V {
    val result = putIfAbsent(key, newValue)
    return result ?: newValue
}

/**
 * Adds spaces to pad this string to the specified length, but adding extra
 * spaces to compensate for combining characters that don't take up horizontal
 * space
 */
fun String.padEndCombining(length: Int): String {
    val combiningCount = this.count { it.category == CharCategory.NON_SPACING_MARK }
    return padEnd(length + combiningCount)
}

fun Path.replaceExtension(newExtension: String): Path {
    val fileNameString = fileName.toString()
    return resolveSibling(
        if ("." in fileNameString)
            fileNameString.split(".").dropLast(1).plus(newExtension).joinToString(".")
        else "$fileNameString.$newExtension"
    )
}
