package com.meamoria.lexurgy

/**
 * Base for Lexurgy errors caused by user mistakes.
 */
expect abstract class UserError(msg: String, cause: Throwable? = null) : Exception

/**
 * Base for Lexurgy SC errors caused by user mistakes.
 */
abstract class LscUserError(msg: String, cause: Throwable? = null) : UserError(msg, cause)
