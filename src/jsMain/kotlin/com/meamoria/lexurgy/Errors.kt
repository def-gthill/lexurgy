package com.meamoria.lexurgy

actual abstract class UserError actual constructor(msg: String, cause: Throwable?) : Exception(msg, cause)
