package com.meamoria.lexurgy

actual fun String.combiningCount(): Int =
    count { Character.getType(it) == Character.NON_SPACING_MARK.toInt() }