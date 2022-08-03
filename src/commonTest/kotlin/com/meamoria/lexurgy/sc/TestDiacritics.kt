package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.normalizeCompose
import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestDiacritics : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "Diacritics should be able to modify features" {
        val ch = lsc(
            """
               |Feature Place(lab, apic)
               |Feature Breath(vcd, plain, aspir)
               |Diacritic ʰ [aspir]
               |Symbol p [lab plain]
               |Symbol b [lab vcd]
               |Symbol t [apic plain]
               |Symbol d [apic vcd]
               |aspiration:
               |    [plain] s => [aspir] *
               |lenition:
               |    [aspir] => [plain] / a _ a
               |    [plain] => [vcd] / a _ a
               |palatal:
               |    t => c / e _
            """.trimMargin()
        )

        ch("psataba") shouldBe "pʰadaba"
        ch("patsaba") shouldBe "pataba"
        ch("petetsa") shouldBe "pecetʰa"
    }

    "Multiple-character diacritics and diacritics with special characters should still work" {
        val ch = lsc(
            """
                Feature Tone(*low, med, high)
                Diacritic skt [med]
                Diacritic fn\+\-\* (before) [high]
                tone-shift:
                    [med] => [high] / s _
            """.trimIndent()
        )

        ch("sasktponesktwisuskt") shouldBe "sfn+-*aponesktwisfn+-*u"
    }

    "Diacritic search should ignore expicit absent values" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(*low, high)
                Feature Depth(*front, back)
                Feature Stress(*unstr, str)
        
                Diacritic ́  [str]
        
                Symbol a [vowel low back]
                Symbol e [vowel low front]
                Symbol i [vowel high front]
                Symbol u [vowel high back]
        
                stress [vowel]:
                [] => [str] / $ _
            """.trimIndent()
        )

        ch("kaki") shouldBe "káki"
        ch("putatu") shouldBe "pútatu"
        ch("ichigaku") shouldBe "íchigaku"
        ch("epistrefu") shouldBe "épistrefu"
    }

    "We should be able to give diacritics matrices with all default values" {
        val ch = lsc(
            """
                Feature place(labial, alveolar)
                Feature manner(nasal)
                Feature +voice
                Feature +vowel
                Feature height(low, high)
                Feature depth(front, central, back)
                Feature +syllabic
                
                Diacritic ̥  [-voice]
                Diacritic ̯  [-syllabic]
                
                Symbol m [labial nasal +voice]
                Symbol n [alveolar nasal +voice]
                Symbol a [low central +syllabic +vowel]
                Symbol i [high front +syllabic +vowel]
                Symbol u [high back +syllabic +vowel]
                
                devoice:
                    h [nasal] => * [-voice]
                
                desyllabify:
                    [high +vowel] => [-syllabic] / [+vowel] _
                
                voice:
                    [nasal -voice] => [+voice] / [+vowel] _ [+vowel]
            """.trimIndent()
        )

        ch("hnaitan") shouldBe "n̥ai̯tan"
        ch("am̥auhn") shouldBe "amau̯n̥"
    }

    "Diacritics declared with (before) should go before their symbol" {
        val ch = lsc(
            """
                Feature Prenasalized(prenasalized)
                Feature Preaspirated(preaspirated)
                Feature Place (labial, alveolar)
                Symbol p [labial]
                Symbol t [alveolar]
                Diacritic ⁿ (before) [prenasalized]
                Diacritic ʰ [preaspirated] (before)
                
                swallow-nasal:
                    n [preaspirated] => * [*Preaspirated prenasalized]
            """.trimIndent()
        )

        ch("anʰtanʰpaʰpa") shouldBe "aⁿtaⁿpaʰpa"
    }

    "Diacritics declared with (first) should go after the first character of the symbol" {
        val ch = lsc(
            """
                Feature +hightone
                Diacritic ́  (first) [+hightone]
                Symbol ou, ei
                Class vowel {a, e, ei, i, o, ou, u}
                hightone:
                    @vowel => [+hightone] / _ {p, t, k}
                    {b, d, g} => {p, t, k}
            """.trimIndent()
        )

        ch("pakeit") shouldBe "pákéit"
        ch("pageid") shouldBe "pakeit"
    }

    "Diacritics should be able to give a diacritic feature to an undeclared symbol" {
        val ch = lsc(
            """
                Feature Length(*short, long)
                Feature Stress(*unstressed, stressed)
                Diacritic ː [long]
                Diacritic ˈ [stressed]
                Class vowel {a, e, i, ɔ, u, ɛ, ə, æ}
                Class cons {b, t, k, m, s}
                
                stress-first-syllable @vowel:
                [] => [stressed] / $ _
                
                stressed-vowel-clusters-merge:
                {eˈə, æˈə, əˈæ, eˈæ, æˈe, əˈe} => {ɛːˈ, aːˈ, ɛːˈ, aːˈ, iːˈ, aːˈ}
                
                remove-stress:
                [stressed] => [unstressed]
            """.trimIndent()
        )

        ch("keət") shouldBe "kɛːt"
        ch("sæek") shouldBe "siːk"
        ch("bætɔm") shouldBe "bætɔm"
    }

    "Floating diacritics should still float when on undeclared symbols" {
        val ch = lsc(
            """
                Feature Stress(*unstressed, stressed)
                Feature Tone(*lowtone, hightone)
                Feature Atr(*natr, atr)
                Diacritic ˈ (before) (floating) [stressed]
                Diacritic ́  (floating) [hightone]
                Diacritic ̘  [atr]
                Class front {e, i}
                w-back:
                    {e, i} => {a, u} / _ w
                stress-raise:
                    {ˈa, ˈe} => {ˈu, ˈi}
                tone-atr:
                    {ú, í} => {u̘, i̘}
                j-front:
                    {a, u} => {e, i} / _ j
                coalesce:
                    ui => ú
                palatalization:
                    t => tʃ / _ @front
            """.trimIndent()
        )

        ch("tˈewtáj") shouldBe "tˈuwtʃéj"
        ch("tˈájtaj") shouldBe "tˈu̘jtʃej"
        ch("tˈuitui") shouldBe "tˈútú"
    }

    "Duplicate diacritic declarations should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Feature Breath(vcd, plain, aspir)
                    Diacritic ʰ [aspir]
                    Diacritic ʰ [plain]
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The diacritic \"ʰ\" is defined more than once"
        }
    }

    "Multiple diacritics with the same feature matrix should produce an LscDuplicateMatrices" {
        shouldThrow<LscDuplicateMatrices> {
            lsc(
                """
                    Feature Breath(vcd, plain, aspir)
                    Diacritic ʰ [aspir]
                    Diacritic ʼ [aspir]
                """.trimIndent()
            )
        }.also {
            it.message shouldBe
                    "The diacritics ʰ and ʼ both have the matrix [aspir]; add features to make them distinct."
        }
    }

    "Symbol literals should match symbols with floating diacritics" {
        val ch = lsc(
            """
                Feature Height(low, high)
                Feature Depth(front, back)
                Feature Stress(*unstressed, stressed)
                Feature Tone(*lowtone, hightone)
                Feature Atr(*natr, atr)
                Diacritic ˈ (before) (floating) [stressed]
                Diacritic ́  (floating) [hightone]
                Diacritic ̘  [atr]
                Symbol a [low back]
                Symbol e [low front]
                Symbol u [high back]
                Symbol i [high front]
                w-back:
                    {e, i} => {a, u} / _ w
                stress-raise:
                    {ˈa, ˈe} => {ˈu, ˈi}
                tone-atr:
                    {ú, í} => {u̘, i̘}
                j-front:
                    {a, u} => {e, i} / _ j
                coalesce:
                    ui => ú
                palatalization:
                    t => tʃ / _ {e, i}
            """.trimIndent()
        )

        ch("tˈewtáj") shouldBe "tˈuwtʃéj"
        ch("tˈájtaj") shouldBe "tˈu̘jtʃej"
        ch("tˈuitui") shouldBe "tˈútú"
    }

    "Matrix to literal changes should preserve floating diacritics" {
        val ch = lsc(
            """
                Feature +hightone, +long
                Diacritic ́  (floating) [+hightone]
                Diacritic ː (floating) [+long]
                
                tonogenesis:
                    [+long] => í / {p, t, k} _
            """.trimIndent()
        )

        ch("piːkuː") shouldBe "píːkíː".normalizeCompose()
    }

    "Symbol literals with ! after them should force an exact match" {
        val ch = lsc(
            """
                Feature Height(low, high)
                Feature Depth(front, back)
                Feature Stress(*unstressed, stressed)
                Feature Tone(*lowtone, hightone)
                Diacritic ˈ (before) (floating) [stressed]
                Diacritic ́  (floating) [hightone]
                Symbol a [low back]
                Symbol e [low front]
                Symbol u [high back]
                Symbol i [high front]
                w-back:
                    {e!, i!} => {a, u} / _ w
                stress-raise:
                    {ˈa!, ˈe!} => {ˈu, ˈi}
                j-front:
                    {a!, u!} => {e, i} / _ j
            """.trimIndent()
        )

        ch("tˈewtew") shouldBe "tˈiwtaw"
        ch("tájtaj") shouldBe "tájtej"
    }

    "Diacritics should be normalized" {
        val ch = lsc(
            """
                Feature +stress
                Diacritic ́  (floating) [+stress]
                vowel-shift:
                    {e, o}&[+stress] => {i, u}
            """.trimIndent()
        )

        ch("téta") shouldBe "títa"
        ch("abódi") shouldBe "abúdi"
    }

    "Letters with built-in diacritics should be treated as symbols even if not declared" {
        val ch = lsc(
            """
                vowel-shift:
                    e => i
            """.trimIndent()
        )

        ch("téte") shouldBe "téti"
    }

    "Letters with built-in diacritics, if declared as symbols, should be decomposed" {
        val ch = lsc(
            """
                Feature foobar(foo, bar)
                Feature +baz
                Symbol á [foo]
                Symbol ç [bar]
                Symbol éi [+baz]
                Diacritic è [+baz]
                foobarize:
                    [foo] => [bar]
                    [bar] => *
                debazize:
                    [+baz] => i
            """.trimIndent()
        )

        ch("banáná") shouldBe "bançnç"
        ch("çanaç") shouldBe "ana"
        ch("béibéi") shouldBe "bibi"
        ch("baèbaè") shouldBe "bibi"
    }

    "Symbols with built-in diacritics match input characters with combining diacritics" {
        val ch = lsc(
            """
                Feature type(vowel, con)

                Symbol e [vowel]
                Symbol ç [con]
                
                rule:
                    [con] => x
            """.trimIndent()
        )

        ch("çe") shouldBe "xe"
    }
})