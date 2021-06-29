package com.meamoria.lexurgy

fun <T, R, S, V> Iterable<T>.zip3(
    other1: Iterable<R>, other2: Iterable<S>, transform: (T, R, S) -> V
): List<V> = zip(other1).zip(other2) { tr, s ->
    val (t, r) = tr
    transform(t, r, s)
}

fun <T, R> List<Iterable<T>>.zipAll(transform: (List<T>) -> R): List<R> {
    val result = mutableListOf<R>()
    val iters = map { it.iterator() }
    while (iters.all { it.hasNext() }) {
        result += transform(iters.map { it.next() })
    }
    return result
}

fun <T, R> List<T>.ifNotEmpty(transform: (List<T>) -> R): R? =
    if (isEmpty()) null else transform(this)

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
 * Returns the number of no-width combining characters in this string
 */
expect fun String.combiningCount(): Int

/**
 * Returns the width of this string in a monospaced font; this is the number
 * of characters not including combining characters that don't take up
 * horizontal space
 */
fun String.lengthCombining(): Int = length - combiningCount()

/**
 * Adds spaces to pad this string to the specified length, but adding extra
 * spaces to compensate for combining characters that don't take up horizontal
 * space
 */
fun String.padEndCombining(length: Int): String {
    return padEnd(length + combiningCount())
}

/**
 * Performs Unicode normalization to NFD form
 */
expect fun String.normalizeDecompose(): String

/**
 * Performs Unicode normalization to NFC form
 */
expect fun String.normalizeCompose(): String

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
