package com.meamoria.lexurgy.sc

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestBlocks : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We can sequence rule expressions rather than having them all happen at once" {
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

    "We can use Else: to apply later rules only if earlier ones didn't match" {
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

    "We can group Then's within an Else or vice versa using parens" {
        val ch = lsc(
            """
                foo:
                    (a => b
                    Then: b => c
                    )
                    Else: (
                        d => e
                        Then: e => f)
            """.trimIndent()
        )

        ch("ababa") shouldBe "ccccc"
        ch("abade") shouldBe "cccde"
        ch("ikide") shouldBe "ikiff"
    }

    "Flat Then-Else combinations raise an error" {
        shouldThrow<LscMixedBlock> {
            lsc(
                """
                    foo:
                        a => b
                        Then: c => d
                        Else: e => f
                """.trimIndent()
            )
        }
    }

    "Elses independently apply rules to each word" {
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

        ch("taːti naːti") shouldBe "taˈːti naˈːti"
        ch("taːti nanti") shouldBe "taˈːti naˈnti"
        ch("tantinan ti") shouldBe "tantinaˈn tiˈ"
        ch("tan tinati") shouldBe "taˈn tinatiˈ"
        ch("tati nati") shouldBe "tatiˈ natiˈ"
    }
})