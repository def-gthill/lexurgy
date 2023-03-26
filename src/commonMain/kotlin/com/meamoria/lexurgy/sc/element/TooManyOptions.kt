package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.LscUserError

fun <T> checkTooManyOptions(matcher: Any, options: List<T>): List<T> =
    if (options.size >= 1000) throw LscTooManyOptions(matcher) else options

class LscTooManyOptions(val matcher: Any) :
    LscUserError(
        "Too many possibilities when matching $matcher"
    )