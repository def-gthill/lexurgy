package com.meamoria.lexurgy

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
