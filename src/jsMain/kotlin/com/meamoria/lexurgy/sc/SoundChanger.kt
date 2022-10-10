package com.meamoria.lexurgy.sc

actual fun <T, U, R> Iterable<T>.fastZipMap(other: Iterable<U>, function: (T, U) -> R): List<R> =
    zip(other).map { function(it.first, it.second) }

actual class LscRuleCrashed actual constructor(
    actual val reason: Exception,
    actual val rule: String,
    actual val originalWord: String,
    actual val currentWord: String,
) :
    Exception(
        "Rule $rule encountered a programming error when applied to word $currentWord (originally $originalWord)",
        reason
    )
