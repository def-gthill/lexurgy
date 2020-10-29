package com.meamoria.lexurgy.sc

actual fun <T, U, R> Iterable<T>.fastZipMap(other: Iterable<U>, function: (T, U) -> R): List<R> =
    zip(other).map { function(it.first, it.second) }
