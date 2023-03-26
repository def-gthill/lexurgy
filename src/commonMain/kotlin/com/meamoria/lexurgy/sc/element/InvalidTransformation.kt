package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.*

class InvalidTransformation(
    val matcher: Matcher, val emitter: Emitter, message: String
) : LscUserError(message)

