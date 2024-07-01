package com.meamoria.lexurgy.sc

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestReusable : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "We should be able to declare reusable elements" {
        val ch = lsc(
            """
                Feature +foo, +bar
                Diacritic ᶠ [+foo]
                Diacritic ᵇ [+bar]
                
                Element fooOrBar {[+foo], [+bar]}
                
                from-foo-or-bar:
                    @fooOrBar => x
                
                to-foo-or-bar:
                    {o, a} => @fooOrBar
                
                conditional-on-foo-or-bar:
                    e => i / @fooOrBar _
            """.trimIndent()
        )

        ch("reᶠurᵇish") shouldBe "rxuxish"
        ch("potato") shouldBe "poᶠtaᵇtoᶠ"
        ch("oeaee") shouldBe "oᶠiaᵇie"
    }

    "Elements can reference other elements" {
        val ch = lsc(
            """
                Feature +foo, +bar, +baz
                Diacritic ᶠ [+foo]
                Diacritic ᵇ [+bar]
                Diacritic ᶻ [+baz]
                
                Element fooOrBar {[+foo], [+bar]}
                Element fooOrBarThenBaz @fooOrBar [+baz]
                
                from-foo-or-bar-then-baz:
                    @fooOrBarThenBaz => x
                
                to-foo-or-bar-then-baz:
                    {o, a} a => @fooOrBarThenBaz
                
                conditional-on-foo-or-bar-then-baz:
                    e => i / @fooOrBarThenBaz _
            """.trimIndent()
        )

        ch("reᶠuᶻrᵇish") shouldBe "rxrᵇish"
        ch("poataato") shouldBe "poᶠaᶻtaᵇaᶻto"
        ch("oaeaᵇee") shouldBe "oᶠaᶻiaᵇee"
    }

    "Elements can reference classes" {
        val ch = lsc(
            """
                Class foo {a, b, c}
                Class bar {d, e, f}
                
                Element baz (@foo @bar)
                
                rule:
                    @baz => {A, B, C} {D, E, F}
            """.trimIndent()
        )

        ch("adcbef") shouldBe "ADcBEf"
    }

    "We get a clear error message if we reference an undefined element" {
        shouldThrow<LscUndefinedName> {
            lsc(
                """
                    Element foo @bar
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The element \"bar\" is not defined"
        }
    }

    "We get a clear error message if we use an element before it's defined" {
        shouldThrow<LscUndefinedName> {
            lsc(
                """
                    Feature +foo, +bar, +baz
                    Diacritic ᶠ [+foo]
                    Diacritic ᵇ [+bar]
                    Diacritic ᶻ [+baz]
                    
                    Element fooOrBarThenBaz @fooOrBar [+baz]
                    Element fooOrBar {[+foo], [+bar]}
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The element \"fooOrBar\" is used before it's defined"
        }
    }

    "We can't reference elements from inside class declarations" {
        shouldThrow<LscIllegalStructure> {
            lsc(
                """
                    Element foo a+
                    Class bar {@foo, b, c}
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "Non-class elements like \"foo\" can't be used in class declarations like \"bar\""
        }
    }

    "We can declare deferred rules" {
        val ch = lsc(
            """
                foo defer:
                    f => b
                    o => a / _ $
                
                rule1:
                    f => h / $ _
                    :foo
                    o => u
                
                rule2:
                    v => f
                    ɔ => o
                    Then:
                    :foo
                    Then:
                    a => e
            """.trimIndent()
        )

        ch("fofo") shouldBe "hube"
        ch("vɔvɔ") shouldBe "bobe"
    }

    "Deferred rules don't execute when first defined" {
        val ch = lsc(
            """
                foo defer:
                    f => b
                
                real-rule:
                    f => x
                    :foo
            """.trimIndent()
        )

        ch("fofo") shouldBe "xoxo"
    }

    "Deferred rules can contain Then and Else blocks" {
        val ch = lsc(
            """
                double defer:
                    a => b
                    Then:
                    b => c
                
                orelse defer:
                    a => b
                    Else:
                    b => c
                
                test-double:
                    x => a
                    Then:
                    :double
                    Then:
                    c => p
                
                test-orelse:
                    {y, z} => {a, b}
                    Then:
                    :orelse
                    Then:
                    {b, c} => {r, s}
            """.trimIndent()
        )

        ch("xyz") shouldBe "prr"
        ch("xz") shouldBe "ps"
    }

    "We get an error if we try to jam a complex deferred rule into simultaneous expressions" {
        shouldThrow<LscIllegalStructure> {
            lsc(
                """
                    double defer:
                        a => b
                        Then:
                        b => c
                    
                    bad:
                        :double
                        c => d
                """.trimIndent()
            )
        }
    }

    "We can reference elements from inside deferred rules" {
        val ch = lsc(
            """
                Element repeater a+ b+
                
                clean-up-repeaters defer:
                    @repeater => x
                
                grow1:
                    p => abcabb
                    Then:
                    :clean-up-repeaters
                
                grow2:
                    q => adaab
                    Then:
                    :clean-up-repeaters
            """.trimIndent()
        )

        ch("quapp") shouldBe "adxuxcxxcx"
    }

    "Deferred rules can reference each other" {
        val ch = lsc(
            """
                do-it-once defer:
                    a => aa
                
                do-it-twice defer:
                    :do-it-once
                    Then:
                    :do-it-once
                
                do-it-four-times defer:
                    :do-it-twice
                    Then:
                    :do-it-twice
                
                rule:
                    :do-it-four-times
            """.trimIndent()
        )

        ch("a") shouldBe "aaaaaaaaaaaaaaaa"
    }

    "Deferred rules can't be referenced before they're declared" {
        shouldThrow<LscUndefinedName> {
            lsc(
                """
                    rule:
                        :too-late
                    
                    too-late defer:
                        a => b
                """.trimIndent()
                )
        }
    }

    "Deferred rules can have modifiers" {
        val ch = lsc(
            """
                class vowel {a, i, u}
                
                assimilate defer propagate @vowel:
                    [] => $1 / []$1 _
                
                rule:
                    i => j / {@vowel _, _ @vowel}
                    Then:
                    :assimilate
            """.trimIndent()
        )

        ch("kabaitimu") shouldBe "kabajtama"
    }

    "Filters on rules still apply in deferred rules they reference" {
        val ch = lsc(
            """
                class vowel {a, i, u}
                
                assimilate defer:
                    u => i / _ i
                
                assimilate-near:
                    :assimilate
                
                assimilate-far @vowel:
                    :assimilate
            """.trimIndent()
        )

        ch("ukubuinu") shouldBe "ukibiinu"
    }

    "Rules inside nested filters work on the intersection of the filters" {
        val ch = lsc(
            """
                class high {i, u}
                class front {i, e}
                
                dissimilate defer @front:
                    [] => a / [] _
                
                only-high @high:
                    :dissimilate
            """.trimIndent()
        )

        ch("ipenima") shouldBe "ipenama"
    }

    "Intermediate romanizers declared immediately before deferred rules work" {
        val ch = lsc(
            """
                romanizer-intermediate:
                    i => o
                
                deferred-rule defer:
                    unchanged
                
                romanizer:
                    a => o
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("tati")) shouldBe mapOf(
            "intermediate" to listOf("tato"),
            null to listOf("toti"),
        )
    }

    "We should be able to declare \"cleanup\" rules that run after every rule" {
        val ch = lsc(
            """
                combine-ai cleanup:
                    ai => e
                
                rule-1:
                    b => i
                rule-2:
                    ec => i
                rule-3:
                    ed => i
            """.trimIndent()
        )

        ch("aaabcd") shouldBe "e"
    }

    "We should be able to turn off \"cleanup\" rules" {
        val ch = lsc(
            """
                combine-ai cleanup:
                    ai => e
                
                rule-1:
                    b => i
                rule-2:
                    ec => i
                
                combine-ai:
                    off
                
                rule-3:
                    ed => i
            """.trimIndent()
        )

        ch("aaabcd") shouldBe "ai"
    }

    "Cleanup rules should run for the first time when declared" {
        val ch = lsc(
            """
                combine-ai cleanup:
                    ai => e
                
                rule-1:
                    eb => i
                rule-2:
                    ec => i
                rule-3:
                    ed => i
            """.trimIndent()
        )

        ch("aaaaibcd") shouldBe "e"
    }

    "We should be able to have multiple cleanup rules with overlapping scope" {
        val ch = lsc(
            """
                combine-ai cleanup:
                    ai => e
                
                rule-1:
                    ek => i
                    Then:
                    t => k
                
                combine-x cleanup:
                    ks => x
                
                rule-2:
                    * => aiks / _ $
                
                combine-ai:
                    off
                
                rule-3:
                    * => aiks / _ $
            """.trimIndent()
        )

        ch("aiksets") shouldBe "isexexaix"
    }

    "Persisting cleanup rules should run BEFORE persisting resyllabification rules" {
        val ch = lsc(
            """
                Class cons {p, t, k, n, s, r, l, h}
                Class vowel {a, e, i, o, u}
                
                Syllables:
                    @cons @vowel
                
                resolve-hiatus cleanup:
                    {ai, au} => {e, o}
                    @vowel => * / @vowel _
                
                drop-h:
                    h => *
            """.trimIndent()
        )

        ch("sahitahunuhi") shouldBe "se.to.nu"
    }

    "Persisting syllabification rules should run BETWEEN a new cleanup rule and a following romanizer" {
        val ch = lsc(
            """
                Syllables:
                    {ba, na, ben, en, e}
                
                rule:
                    * => i / a _
                
                combine-ai cleanup:
                    ai => e
                
                romanizer-x:
                    unchanged
                
                rule-2:
                    e => i
                
                Syllables:
                    clear
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("banana")) shouldBe
                mapOf("x" to listOf("ben.en.e"), null to listOf("binini"))
    }

    "Persisting syllabification rules should run BEFORE any intermediate romanizers" {
        val ch = lsc(
            """
                Syllables:
                    {ba, na, ben, en, e}
                
                rule:
                    a => e
                
                romanizer-x:
                    unchanged
                
                rule-2:
                    e => i
                
                Syllables:
                    clear
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("banana")) shouldBe
                mapOf("x" to listOf("ben.en.e"), null to listOf("binini"))
    }

    "Cleanup rules don't run after the final romanizer" {
        val ch = lsc(
            """
                rule cleanup:
                    o => a
                
                romanizer:
                    u => o
            """.trimIndent()
        )

        ch("bouba") shouldBe "baoba"
    }

    "The \"cleanup\" modifier should be invalid in blocks" {
        shouldThrow<LscInvalidModifier> {
            lsc(
                """
                    rule:
                        unchanged
                        Then cleanup:
                        unchanged
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "Invalid modifier \"cleanup\" applied to \"<Then>\""
        }
    }
})