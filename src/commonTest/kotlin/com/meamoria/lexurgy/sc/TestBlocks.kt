package com.meamoria.lexurgy.sc

import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.fail
import com.meamoria.mpp.kotest.shouldBe

@Suppress("unused")
class TestBlocks : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We should be able to sequence rule expressions rather than having them all happen at once" {
        val chain = lsc(
            """
                Symbol ts
                chain:
                t => ts
                ts => s
                s => h
                h => *
            """.trimIndent()
        )

        val nonchain = lsc(
            """
                Symbol ts
                not-a-chain:
                t => ts
                Then: ts => s
                Then:
                s => h
                h => *
            """.trimIndent()
        )

        chain("tatsasaha") shouldBe "tsasahaa"
        nonchain("tatsasaha") shouldBe "hahahaa"
    }

    "We should be able to use Else: to apply later rules only if earlier ones didn't match" {
        val ch = lsc(
            """
                Feature type(cons, vowel)
                Feature ab(a, b)
                Feature +stress, +long
                Symbol a [vowel a]
                Symbol i [vowel b]
                Symbol t [cons a]
                Symbol n [cons b]
                Diacritic ˈ [+stress]
                Diacritic ː [+long]
                assign-stress:
                    [+long] => [+stress] / _ {[cons], [-long vowel]}* $
                    Else: [vowel] => [+stress] / _ [cons]+ ([cons] [-stress vowel])* $
                    Else: [vowel] => [+stress] / _ [cons]* $
            """.trimIndent()
        )

        ch("taːtinaːti") shouldBe "taːtinaˈːti"
        ch("taːtinanti") shouldBe "taˈːtinanti"
        ch("tantinanti") shouldBe "tantinaˈnti"
        ch("tantinati") shouldBe "taˈntinati"
        ch("tatinati") shouldBe "tatinatiˈ"
    }

    "We should be able to group Then's within an Else or vice versa using parens" {
        fail("Not yet!")
    }

    "Flat Then-Else combinations should raise an error" {
        fail("Not yet!")
    }

    "Elses should independently apply rules to each word" {
        fail("Not yet!")
    }
})