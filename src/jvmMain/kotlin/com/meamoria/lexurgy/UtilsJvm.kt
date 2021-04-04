package com.meamoria.lexurgy

import java.text.Normalizer

actual fun String.combiningCount(): Int =
    count { Character.getType(it) == Character.NON_SPACING_MARK.toInt() }

actual fun String.normalizeDecompose(): String = Normalizer.normalize(this, Normalizer.Form.NFD)

actual fun String.normalizeCompose(): String = Normalizer.normalize(this, Normalizer.Form.NFC)