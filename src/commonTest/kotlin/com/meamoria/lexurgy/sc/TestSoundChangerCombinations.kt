package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.sc.element.InvalidTransformation
import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldBeInstanceOf
import com.meamoria.mpp.kotest.shouldThrow

// Testing every transformerToXXX method in the various Matchers
@Suppress("unused")
class TestSoundChangerCombinations : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We get an error if we try to transform a list to a list of a different length" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("bad-alts:\n{p, t, k} => {f, ts}")
        }.also {
            it.cause.shouldBeInstanceOf<InvalidTransformation>()
        }
    }

    "The parser should distribute sequences into adjacent alternative lists if the lengths match" {
        val ch = lsc(
            """
                two-to-one:
                    a {e, o} => {e e, o o}
                three-to-one:
                    {a, i} ɛ {i, a} => {ei * *, ia * *}
            """.trimIndent()
        )

        ch("baela") shouldBe "beela"
        ch("maomaeteo") shouldBe "moomeeteo"
        ch("kaɛitiɛa") shouldBe "keitia"
    }

    "But if the lengths don't match, report the mismatch at the top level" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("bad-sequence-in-alternative:\na {e, o} => {e e, o}")
        }.also {
            it.cause.shouldBeInstanceOf<InvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("a {e, o} => {e e, o}") of rule "bad-sequence-in-alternative"
                Found 2 elements ("a", "{e, o}") on the left side of the arrow but 1 element ("{(e e), o}") on the right side
            """.trimIndent()
        }

        shouldThrow<LscInvalidRuleExpression> {
            lsc("bad-alternative-in-sequence:\na {e, i, o} => {e e, o o}")
        }.also {
            it.cause.shouldBeInstanceOf<InvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("a {e, i, o} => {e e, o o}") of rule "bad-alternative-in-sequence"
                Found 2 elements ("a", "{e, i, o}") on the left side of the arrow but 1 element ("{(e e), (o o)}") on the right side
            """.trimIndent()
        }
    }

    "We should be able to apply a conditional change to everything in a sequence, " +
            "but an independent change should replace the entire sequence" {
                val ch = lsc(
                    """
                        Feature Tone(*low, high)
                        Diacritic ́  (floating) [high]
                        Class vowel {a, ɑ, e, i, o, u}
                        Class lowvowel {a, ɑ}
                        Class highvowel {i, u}
                        
                        high-tone-after-s:
                            @vowel @highvowel? => [high] / s _
                        
                        vowel-coalescence:
                            @lowvowel i => e
                            
                    """.trimIndent()
                )

                ch("tasauni") shouldBe "tasáúni"
                ch("tasainisia") shouldBe "tasenisía"
            }

    "We should be able to transform a sequence to another sequence of a different length if the " +
            "second sequence is independent" {
                val ch = lsc(
                    """
                        Class stop {p, t, k}
                        weird-metathesis:
                            r @stop$1 s => s $1
                    """.trimIndent()
                )

                ch("arks") shouldBe "ask"
            }

    "Alternative lists should be lifted out of repeaters to line up with output alternative lists" {
        val ch = lsc(
            """
                multi-voice-intervocalic:
                    {p, t, k}+ => {b, d, g} / {a, i, u} _ {a, i, u}
            """.trimIndent()
        )

        ch("aptkpiptkp") shouldBe "abdgbiptkp"
    }

    "Sequences should be lifted out of repeaters to line up with output sequences" {
        val ch = lsc(
            """
                Feature Tone(*low, high)
                Diacritic ́  (floating) [high]
                Class vowel {a, e, i, o, u}
                weird-tone-spreading:
                    (@vowel&[high] @vowel)+ => [] [high] / k _
            """.trimIndent()
        )

        ch("áuóikáuóináuói") shouldBe "áuóikáúóínáuói"
    }

    "Transforming a non-sequence repeater to a sequence shouldn't repeat the sequence" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                copy-after-i-and-reduce:
                    i+ => i $1 / (@vowel&!i)$1 _
            """.trimIndent()
        )

        ch("boiiiigii") shouldBe "boiogii"
    }

    "We should be able to transform an alternative list to an independent sequence" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class fricative {f, s, x}
                Class nasal {m, n}
                crazy-cycle:
                    {@fricative$2 @nasal$3 @stop$1 ^, @nasal$3 @stop$1 @fricative$2 ^} => $1 $2 $3
            """.trimIndent()
        )

        ch("fnp^") shouldBe "pfn"
        ch("mks^mks") shouldBe "ksmmks"
    }

    "We should be able to lift sequences out of intersections" {
        val ch = lsc(
            """
                Feature Tone(*low, high)
                Diacritic ́  (floating) [high]
                waves:
                    (a+ i+ a+)&([high]+ [low]+ [high]+) => [low] [high] [low]
            """.trimIndent()
        )

        ch("baaáááíííiiíáá") shouldBe "baaaaaííííííaa"
    }

    "We should be able to lift sequences out of captures" {
        val ch = lsc(
            """
                Feature Stressed (*unstressed, stressed)
                Diacritic ˈ (floating) [stressed]
                Class consonant {p, t, k, s, m, n}
                Class vowel {a, e, i, o, u}
                stress-first-syllable @vowel:
                    [] => [stressed] / $ _
                copy-first-cv:
                    * (@consonant @vowel)$1 => $1 ([] [unstressed]) / $ _
            """.trimIndent()
        )

        ch("patu") shouldBe "paˈpatu"
        ch("sikema") shouldBe "siˈsikema"
    }
})