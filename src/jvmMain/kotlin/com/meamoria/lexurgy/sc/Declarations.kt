package com.meamoria.lexurgy.sc

import java.util.concurrent.ConcurrentHashMap

actual typealias Cache<K, V> = ConcurrentHashMap<K, V>
