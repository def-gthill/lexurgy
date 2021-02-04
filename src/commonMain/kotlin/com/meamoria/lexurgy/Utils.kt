package com.meamoria.lexurgy

fun <T, R, S, V> Iterable<T>.zip3(
    other1: Iterable<R>, other2: Iterable<S>, transform: (T, R, S) -> V
): List<V> = zip(other1).zip(other2) { tr, s ->
    val (t, r) = tr
    transform(t, r, s)
}

fun <T, R> Iterable<Iterable<T>>.nestedMap(transform: (T) -> R): List<List<R>> =
    map { it.map(transform) }

/**
 * Splits the iterable at copies of the specified separator.
 * The separator is not part of any of the returned lists.
 */
fun <T> Iterable<T>.split(separator: T): List<List<T>> {
    val result = mutableListOf<List<T>>()
    var remaining = this.toList()
    while (true) {
        val index = remaining.indexOf(separator)
        if (index < 0) break
        result += remaining.take(index)
        remaining = remaining.drop(index + 1)
    }
    result += remaining
    return result
}

/**
 * Joins the iterables with the specified separator.
 */
fun <T> Iterable<Iterable<T>>.join(separator: T): List<T> =
    flatMap { it + separator }.dropLast(1)

fun <T> Iterable<T>.subsets(): Sequence<List<T>> {
    val list = toList()
    return generateSequence(emptyList()) { prev ->
        this.withIndex().find { it.index >= prev.size || it.value != prev[it.index] }?.let {
            listOf(list[it.index]) + prev.drop(it.index)
        }
    }
}

fun <T> Iterable<T>.pairs(): Sequence<Pair<T, T>> = subsets().filter { it.size == 2 }.map { it[0] to it[1] }

/**
 * Adds spaces to pad this string to the specified length, but adding extra
 * spaces to compensate for combining characters that don't take up horizontal
 * space
 */
fun String.padEndCombining(length: Int): String {
    // \p{Mn} is the Unicode property for non-spacing marks
    val combiningCount = Regex("\\p{Mn}").findAll(this).toList().size
    return padEnd(length + combiningCount)
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
