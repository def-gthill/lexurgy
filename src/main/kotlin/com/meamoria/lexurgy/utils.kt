package com.meamoria.lexurgy

import java.nio.file.Path

fun <K, V> MutableMap<K, V>.setdefault(key: K, newValue: V): V {
    val result = putIfAbsent(key, newValue)
    return result ?: newValue
}

fun <T, R, S, V> Iterable<T>.zip3(
    other1: Iterable<R>, other2: Iterable<S>, transform: (T, R, S) -> V
): List<V> = zip(other1).zip(other2) { tr, s ->
    val (t, r) = tr
    transform(t, r, s)
}

fun <T, R> Iterable<Iterable<T>>.nestedMap(transform: (T) -> R): List<List<R>> =
    map { it.map(transform) }

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
