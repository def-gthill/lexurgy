package com.meamoria.lexurgy.sc

import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@ExperimentalTime
fun main() {
    val alphabet =
        "{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z}"
    val reversedAlphabet =
        "{z, y, x, w, v, u, t, s, r, q, p, o, n, m, l, k, j, i, h, g, f, e, d, c, b, a}"

    val ch = SoundChanger.fromLsc(
        """
            kill-alphabet:
            $alphabet => *
        """.trimIndent()
    )

    println("Kill alphabet:")
    println(
        measureTimedValue {
            ch.change(Array(500000) { "(zzzz)" }.asList()).last()
        }
    ) // Baseline time: 7.5 seconds

    val ch2 = SoundChanger.fromLsc(
        """
            reverse-alphabet:
            $alphabet => $reversedAlphabet
        """.trimIndent()
    )

    println("Transform alphabet:")
    println(
        measureTimedValue {
            ch2.change(Array(500000) { "(zzzz)" }.asList()).last()
        }
    ) // Baseline time: 7 seconds

    val ch3 = SoundChanger.fromLsc(
        """
            feature +pointless
            diacritic \:\( (floating) [+pointless]
            reverse-alphabet-floating:
            $alphabet => $reversedAlphabet
        """.trimIndent()
    )

    println("Transform alphabet with floating diacritics:")
    println(
        measureTimedValue {
            ch3.change(Array(500000) { "(z:(z:(z:(z:()" }.asList()).last()
        }
    ) // Baseline time: 9 seconds
}
