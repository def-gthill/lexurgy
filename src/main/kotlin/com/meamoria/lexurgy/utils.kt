package com.meamoria.lexurgy

fun <K, V> MutableMap<K, V>.setdefault(key: K, newValue: V): V {
    val result = putIfAbsent(key, newValue)
    return result ?: newValue
}