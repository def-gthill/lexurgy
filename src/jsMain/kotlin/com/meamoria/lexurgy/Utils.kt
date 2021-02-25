package com.meamoria.lexurgy

import com.meamoria.mpp.xregexp.test
import kotlin.js.RegExp

actual fun String.combiningCount(): Int =
    count { test(it.toString(), RegExp("\\p{Mn}")) }
