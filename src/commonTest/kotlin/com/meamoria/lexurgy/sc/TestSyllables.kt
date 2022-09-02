package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.SyllableStructureViolated
import com.meamoria.mpp.kotest.StringSpec
import com.meamoria.mpp.kotest.fail
import com.meamoria.mpp.kotest.shouldBe
import com.meamoria.mpp.kotest.shouldThrow

@Suppress("unused")
class TestSyllables : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "Sound changes should work across explicit syllable boundaries" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Syllables:
                    explicit
                intervocalic-voicing:
                    {p, t, k} => {b, d, g} / @vowel _ @vowel
                t-assimilation:
                    {pt, kt} => tt
            """.trimIndent()
        )

        ch("ko.li.mo") shouldBe "ko.li.mo"
        ch("k.opi.mo") shouldBe "k.obi.mo"
        ch("ko.pi.ko") shouldBe "ko.bi.go"
        ch("kop.tik.to") shouldBe "kot.tit.to"
    }

    "We should be able to insert explicit syllable boundaries with rules" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Syllables:
                    explicit
                insert-syllable-break:
                    * => . / @vowel _ @vowel
            """.trimIndent()
        )

        ch("muo") shouldBe "mu.o"
    }

    "We should be able to insert syllable boundary characters when not using syllables" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                insert-syllable-break:
                    * => . / @vowel _ @vowel
            """.trimIndent()
        )

        ch("muo") shouldBe "mu.o"
    }

    "We should be able to delete explicit syllable boundaries with rules" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Syllables:
                    explicit
                make-diphthongs:
                    . => * / @vowel _ @vowel
            """.trimIndent()
        )

        ch("mu.o.ti") shouldBe "muo.ti"

        val ch2 = lsc(
            """
                Class vowel {a, e, i, o, u}
                Syllables:
                    explicit
                swallow-vowel:
                    . @vowel => * / @vowel _
            """.trimIndent()
        )

        ch2("mu.o.tia") shouldBe "mu.tia"
    }

    "Explicit syllable breaks in sequences should be removed" {
        val ch = lsc(
            """
                Feature +foo
                Diacritic ǃ [+foo]
                Syllables:
                    explicit
                syllable-break-in-sequence:
                    . a => e [+foo]
            """.trimIndent()
        )

        ch("fi.an") shouldBe "fieaǃn"

        val ch2 = lsc(
            """
                Syllables:
                    explicit
                foo:
                    ab . ce => i
            """.trimIndent()
        )

        ch2("dab.cef") shouldBe "dif"
        ch2("du.ab.cef") shouldBe "du.if"
        ch2("dab.ce.uf") shouldBe "di.uf"

        val ch3 = lsc(
            """
                Class vowel {a, e, i, o, u}
                Syllables:
                    explicit
                swap-coalesce:
                    @vowel$1 . @vowel$2 => $2 $1
            """.trimIndent()
        )

        ch3("ma.i.tu.a") shouldBe "mia.tau"

        val ch4 = lsc(
            """
                Syllables:
                    explicit
                abc:
                    . a . => b c
            """.trimIndent()
        )

        ch4("mua.a.ah") shouldBe "muabcah"
    }

    "An explicit syllable break can be removed after an optional that doesn't match" {
        val ch = lsc(
            """
                Syllables:
                  explicit
                
                remove-break:
                  t? . => [] *
            """.trimIndent()
        )

        ch("i.ti") shouldBe "iti"

        val ch2 = lsc(
            """
                Syllables:
                  explicit
                
                remove-break:
                  i t? . => i [] *
            """.trimIndent()
        )

        ch2("i.ti") shouldBe "iti"
    }

    "Explicit syllable breaks in repeaters should be removed" {
        val ch = lsc(
            """
                Feature +foo
                Diacritic ́  [+foo]
                Syllables:
                    explicit
                syllable-break-in-repeater:
                    (. a)+ => [+foo]
            """.trimIndent()
        )

        ch("pe.a.a.at") shouldBe "peááát"

        val ch2 = lsc(
            """
                Syllables:
                    explicit
                syllable-break-in-repeater:
                    (. a)+ => i
            """.trimIndent()
        )

        ch2("pe.a.a.at") shouldBe "peit"
    }

    "We should be able to delete syllable boundary characters when not using syllables" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                make-diphthongs:
                    . => * / @vowel _ @vowel
            """.trimIndent()
        )

        ch("mu.o.ti") shouldBe "muo.ti"
    }

    "Captures should work across syllable boundaries" {
        val ch = lsc(
            """
                feature +long
                diacritic ː [+long]
                Syllables:
                 explicit
                coalesce:
                 []$1 $1 => [+long] *
            """.trimIndent()
        )

        ch("to.o.nat") shouldBe "toː.nat"
        ch("to.o") shouldBe "toː"
    }

    "We should be able to define automatic syllabification rules" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, b, d, g, s, m, n, l, r}
                Syllables:
                    @cons @vowel
            """.trimIndent()
        )

        ch("kolimo") shouldBe "ko.li.mo"
        ch("tiramisu") shouldBe "ti.ra.mi.su"
    }

    "We should get helpful error messages when a word violates the syllabification rules" {
        val ch = lsc(
            """
                Feature +long, (syllable) +foo, (syllable) +bar, (syllable) +aargh
                Diacritic ː [+long]
                Diacritic ᶠ (first) [+foo]
                Diacritic ᵇ (before) [+bar]
                Diacritic ᵃ [+aargh]
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, b, d, g, s, m, n, l, r}
                Syllables:
                    @cons @vowel
            """.trimIndent()
        )

        shouldThrow<SyllableStructureViolated> {
            ch("bahu")
        }.also {
            it.message shouldBe
                    "The segment \"h\" in \"ba(h)u\" doesn't fit the syllable structure; " +
                    "no syllable pattern can start with \"h\""
        }

        shouldThrow<SyllableStructureViolated> {
            ch("katmandu")
        }.also {
            it.message shouldBe
                    "The segment \"m\" in \"kat(m)andu\" doesn't fit the syllable structure; " +
                    "no syllable pattern that starts with \"t\" can continue with \"m\""
        }

        shouldThrow<SyllableStructureViolated> {
            ch("kamadut")
        }.also {
            it.message shouldBe
                    "The word \"kamadut\" doesn't fit the syllable structure; " +
                    "the last syllable \"t\" is incomplete"
        }

        shouldThrow<SyllableStructureViolated> {
            ch("kaːmaːduː")
        }.also {
            it.message shouldBe
                    "The segment \"aː\" in \"k(aː)maːduː\" doesn't fit the syllable structure; " +
                    "no syllable pattern that starts with \"k\" can continue with \"aː\""
        }

        shouldThrow<SyllableStructureViolated> {
            ch("ᵇkᶠtamanduᵃ")
        }.also {
            it.message shouldBe
                    "The segment \"t\" in \"ᵇkᶠ(t)amanduᵃ\" doesn't fit the syllable structure; " +
                    "no syllable pattern that starts with \"k\" can continue with \"t\""
        }
    }

    "Nested sequences should be handled correctly" {
        val ch = lsc(
            """
                Syllables:
                    (a b) (c d)
            """.trimIndent()
        )

        shouldThrow<SyllableStructureViolated> {
            ch("acac")
        }.also {
            it.message shouldBe
                    "The segment \"c\" in \"a(c)ac\" doesn't fit the syllable structure; " +
                    "no syllable pattern that starts with \"a\" can continue with \"c\""
        }

        shouldThrow<SyllableStructureViolated> {
            ch("abcabc")
        }.also {
            it.message shouldBe
                    "The segment \"a\" in \"abc(a)bc\" doesn't fit the syllable structure; " +
                    "no syllable pattern that starts with \"abc\" can continue with \"a\""
        }
    }

    "Sequences in repeaters should be handled correctly" {
        val ch = lsc(
            """
                Syllables:
                    (b a) (n a)+
            """.trimIndent()
        )

        shouldThrow<SyllableStructureViolated> {
            ch("banabanani")
        }.also {
            it.message shouldBe
                    "The segment \"i\" in \"banabanan(i)\" doesn't fit the syllable structure; " +
                    "no syllable pattern that starts with \"banan\" can continue with \"i\""
        }
    }

    "We should be able to use complex structures in syllabification rules" {
        val ch = lsc(
            """
                Feature type(*cons, vowel)
                Feature height(low, mid, high)
                Feature frontness(front, central, back)
                Symbol a [low central vowel]
                Symbol e [mid front vowel]
                Symbol i [high front vowel]
                Symbol o [mid back vowel]
                Symbol u [high back vowel]
                Syllables:
                    s? {{p, t, k} r, [cons]} [vowel] [cons]? // [vowel] _
                    [cons] [vowel] [cons]?
            """.trimIndent()
        )

        ch("jaksprat") shouldBe "jak.sprat"
        ch("wisnagnit") shouldBe "wis.nag.nit"

        shouldThrow<SyllableStructureViolated> { ch("mtar") }
        shouldThrow<SyllableStructureViolated> { ch("antki") }
    }

    "Syllabification should proceed left-to-right, always choosing the shortest syllable that doesn't cause subsequent syllables to fail" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel (t s)?
            """.trimIndent()
        )

        ch("patso") shouldBe "pats.o"
    }

    "Words that have been automatically syllabified should be re-syllabified after every named rule" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                r-drop:
                    r => * / @cons _
                hiatus-collapse:
                    {ea, oa, ae, ao} => a
            """.trimIndent()
        )

        ch("patran") shouldBe "pa.tan"
        ch("kaonira") shouldBe "ka.ni.ra"
    }

    "The <syl> token should match any single syllable" {
        val ch = lsc(
            """
                Feature +stress
                Diacritic ˈ (before) (floating) [+stress]
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                stress-penult:
                    @vowel => [+stress] / _ @cons? <syl> $
            """.trimIndent()
        )

        ch("kopiko") shouldBe "ko.pˈi.ko"
        ch("maria") shouldBe "ma.rˈi.a"
        ch("salamanka") shouldBe "sa.la.mˈan.ka"

        val ch2 = lsc(
            """
                Feature +stress
                Diacritic ˈ (before) (floating) [+stress]
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                stress-second:
                    @vowel => [+stress] / $ <syl> @cons? _
            """.trimIndent()
        )

        ch2("kopiko") shouldBe "ko.pˈi.ko"
        ch2("maria") shouldBe "ma.rˈi.a"
        ch2("salamanka") shouldBe "sa.lˈa.man.ka"
    }

    "<syl> should match the entirety of a one-syllable word" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                    I+ / _ $
                tally-syllables:
                    <syl> => I
            """.trimIndent()
        )

        ch("kopiko") shouldBe "III"
        ch("sampo") shouldBe "II"
        ch("tal") shouldBe "I"
    }

    "The . matcher should match the edge of any syllable" {
        val ch = lsc(
            """
                Feature +aspir
                Diacritic ʰ [+aspir]
                Class cons {p, t, k, s, m, n, l, r} 
                Syllables:
                    explicit
                drop-codas:
                    @cons => * / _ .
                aspirate-onset:
                    {p, t, k} => [+aspir] / . _
            """.trimIndent()
        )

        ch("tu.kar") shouldBe "tʰu.kʰa"
        ch("tuk.ar") shouldBe "tʰu.a"
    }

    "We should be able to declare and reference syllable-level features" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Diacritic ˈ (before) [+stress]
                Class vowel {a, æ, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                stress-penult:
                    <syl> => [+stress] / _ <syl> $
                stress-raising:
                    a&[+stress] => æ
            """.trimIndent()
        )

        ch("piko") shouldBe "ˈpi.ko"
        ch("kopiko") shouldBe "ko.ˈpi.ko"
        ch("maria") shouldBe "ma.ˈri.a"
        ch("salamanka") shouldBe "sa.la.ˈmæn.ka"
    }

    "We should get an error if we try to mix features from different levels on a diacritic" {
        shouldThrow<LscInvalidFeatureLevel> {
            lsc("Feature (syllable) +stress\nFeature +long\nDiacritic ˈː [+stress +long]")
        }
    }

    "We should get an error if we try to give symbols syllable-level diacritics" {
        shouldThrow<LscInvalidFeatureLevel> {
            lsc("Feature (syllable) +stress\nSymbol o [+stress]")
        }
    }

    "We should be able to assign syllable-level features in the syllabification rules" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Feature (syllable) sylType(light, heavy)
                Feature +long
                Diacritic ˈ (before) [+stress]
                Diacritic ¹ [light]
                Diacritic ² [heavy]
                Diacritic ː (floating) [+long]
                Class vowel {a, e, i, o, u}
                Class diphthong {aj, oj}
                Class cons {p, t, k, b, d, g, f, s, h, m, n, l, r, w}
                Syllables:
                    @cons? {@vowel, @diphthong} @cons => [heavy]
                    @cons? @diphthong => [heavy]
                    @cons? @vowel&[+long] => [heavy]
                    @cons? @vowel => [light]
                stress:
                    <syl>&[heavy] => [+stress] / _ <syl> $
                    Else:
                    <syl> => [+stress] / _ <syl> <syl> $
                coda-dropping:
                    @cons => * / _ @cons
            """.trimIndent()
        )

        ch("feːminaj") shouldBe "ˈfeː².mi¹.naj²"
        ch("pueroː") shouldBe "ˈpu¹.e¹.roː²"
        ch("wolukris") shouldBe "wo¹.ˈlu¹.ris²"
        ch("wideːre") shouldBe "wi¹.ˈdeː².re¹"
    }

    "We should be able to use propagate when assigning stress" {
        val ch = lsc(
            """
                Feature type(*cons, vowel)
                Feature (syllable) stress(*unstressed, secondary, primary)
                Diacritic ˈ (before) [primary]
                Diacritic ˌ (before) [secondary]
                Symbol a [vowel]
                Syllables:
                    [cons]? [vowel]
                primary-stress-second-last-syllable:
                    <syl> => [primary] / _ <syl> ${'$'}
                add-secondary-stress propagate:
                    <syl> => [secondary] / _ <syl> {[primary], [secondary]}
            """.trimIndent()
        )

        ch("papapapapapapapa") shouldBe "ˌpa.pa.ˌpa.pa.ˌpa.pa.ˈpa.pa"
    }

    "We should be able to return syllable-level features to their default values" {
        val ch = lsc(
            """
                Feature (syllable) +stress, (syllable) +test
                Diacritic ˈ (before) [+stress]
                Diacritic ^ [+test]
                Syllables:
                    explicit
                remove-stress:
                    <syl>&[+stress] => [-stress]
            """.trimIndent()
        )

        ch("ˈfu.ba") shouldBe "fu.ba"
        ch("ka.lu.ˈma") shouldBe "ka.lu.ma"
        ch("con.ˈtest^") shouldBe "con.test^"
        ch("ˈtest^") shouldBe "test^"
    }

    "Default syllable level features shouldn't match off the end of a word" {
        val ch = lsc(
            """
                Feature (syllable) +foo
                Diacritic ^ [+foo]
                Syllables:
                    explicit
                foo-everything:
                    [-foo] => [+foo]
            """.trimIndent()
        )

        ch("ba.na.na") shouldBe "ba^.na^.na^"
    }

    "We should be able to mix segment-level and syllable-level features in matrices" {
        val ch = lsc(
            """
                Feature type(*cons, vowel)
                Feature height(low, mid, high)
                Feature frontness(front, central, back)
                Feature (syllable) +stress
                Diacritic ˈ (before) [+stress]
                Symbol a [low central vowel]
                Symbol e [mid front vowel]
                Symbol i [high front vowel]
                Symbol o [mid back vowel]
                Symbol u [high back vowel]
                
                Syllables:
                    explicit
                
                stress-raising:
                    [mid +stress] => [high]
                
                high-stressing-lowering:
                    [high] => [mid +stress] / _ $
                    Then:
                    [vowel +stress] => [-stress] / _ []* [vowel +stress]
            """.trimIndent()
        )

        ch("pa.ˈte.na") shouldBe "pa.ˈti.na"
        ch("pa.ˈta.ni") shouldBe "pa.ta.ˈne"
    }

    "Syllable-level features should persist through other kind of rules" {
        val ch = lsc(
            """
                Feature +long, (syllable) +stress
                Diacritic ˈ (before) [+stress]
                Diacritic ː [+long]
                Class bar {b, d}
                Class baz {s, z}
                Syllables:
                    explicit
                shorten:
                    [+long] => [-long]
                vowel-shift:
                    u! => y
                metathesis:
                    @baz$1 @bar$2 => $2 $1
            """.trimIndent()
        )

        ch("ˈfoː.baːr") shouldBe "ˈfo.bar"
        ch("ˈfu.bar") shouldBe "ˈfy.bar"
        ch("ˈbaz.bar") shouldBe "ˈbab.zar"
    }

    "Syllable-level features should persist through glomination" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Diacritic ˈ (before) [+stress]
                Syllables:
                    explicit
                glomination:
                    r $$ => .
                    $$ => .
            """.trimIndent()
        )

        ch("ˈbat ˈman") shouldBe "ˈbat.ˈman"
        ch("ˈbar ˈman") shouldBe "ˈba.ˈman"
    }

    "Syllable-level features should persist through epenthesis" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Diacritic ˈ (before) [+stress]
                
                Syllables:
                 explicit
                
                gliding:
                 * => j / $ _ {i,e}
            """.trimIndent()
        )

        ch("ˈe.ka") shouldBe "ˈje.ka"
        ch("e.ˈka") shouldBe "je.ˈka"
    }

    "Syllable-level features should persist through \"empty swaps\"" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                
                Diacritic ˈ (before) [+stress]
                
                Class vowel {a, i, u}
                Class cons {p, t, k, x}
                
                Syllables:
                 @cons? @vowel @cons?
                
                stress-assignement:
                 <syl> => [+stress] / _ <syl> $
                
                neutralisation:
                 * @cons => x * / _ a
            """.trimIndent()
        )

        ch("katak") shouldBe "ˈxa.xak"
        ch("akatak") shouldBe "a.ˈxa.xak"
    }

    "Syllable-level features should persist when adjusting other features in sequences" {
        val ch = lsc(
            """
                Feature (syllable) Tone(*neutral, low, high)
                Feature (syllable) +stress
                
                Diacritic L [low]
                Diacritic H [high]
                Diacritic ' (before) [+stress]
                
                Syllables:
                 b a
                
                tone-assignment:
                 <syl> => [high] / $ _
                 [] => [low]
                
                stress-assignment:
                 <syl> => [+stress] / _ $
                
                romanizer-initial:
                 unchanged
                
                stress-retraction:
                 <syl>&[high] <syl>&[low] => [+stress] [-stress] / _ $
            """.trimIndent()
        )

        ch("baba") shouldBe "'baH.baL"
        ch("bababa") shouldBe "baH.baL.'baL"
    }

    "Syllable-level features persist when manually merging two syllables" {
        val ch = lsc(
            """
                Feature (syllable) +stress

                Diacritic ˈ (before) [+stress]
                
                Syllables:
                    explicit
                
                syllable-merge:
                    . => * / i _ t
            """.trimIndent()
        )

        ch("ˈi.te.ti") shouldBe "ˈite.ti"
        ch("i.ˈte.ti") shouldBe "ˈite.ti"

        val ch2 = lsc(
            """
                Feature (syllable) +stress

                Diacritic ˈ (before) [+stress]
                
                Syllables:
                  explicit
                
                complex-syllable-merge:
                  . t ə => * [] *
            """.trimIndent()
        )

        ch2("ˈi.tə.ti") shouldBe "ˈit.ti"
    }

    "We can explicitly override syllable-level features while manually merging syllables" {
        val ch = lsc(
            """
                Feature (syllable) +stress

                Diacritic ˈ (before) [+stress]
                
                Syllables:
                    explicit
                
                syllable-merge:
                    . t e => * t [-stress]
            """.trimIndent()
        )

        ch("ˈi.te.ti") shouldBe "ite.ti"
        ch("i.ˈte.ti") shouldBe "ite.ti"
    }

    "Syllable-level features should persist through filter rules" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                
                Diacritic ˈ (before) [+stress]
                
                Class vowel {a, e, i, o, u}
                
                Syllables:
                 explicit
                
                umlaut @vowel:
                 {a, e}&[+stress] => {e, i} / _ i&[-stress]
            """.trimIndent()
        )

        ch("ˈke.li") shouldBe "ˈki.li"
        ch("ˈken.li") shouldBe "ˈkin.li"
    }

    "Syllable-level features should stay as close to their original sounds as possible when resyllabifying" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Diacritic ˈ (before) [+stress]
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    (@cons // @vowel _)? @cons? @vowel @cons?
                stress-penult:
                    <syl> => [+stress] / _ <syl> $
                syncope:
                    @vowel => * / _ <syl>&[+stress]
                final-mid-loss:
                    {e, o} => * / _ $
            """.trimIndent()
        )

        ch("kamina") shouldBe "ˈkmi.na"
        ch("arensa") shouldBe "ˈren.sa"
        ch("akamina") shouldBe "ak.ˈmi.na"
        ch("akamine") shouldBe "ak.ˈmin"
    }

    "Coda dropping should work without syllable features bleeding onto the next syllable" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Diacritic ˈ (before) [+stress]
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                drop-coda:
                    @cons => * / _ .
                Syllables:
                    @cons? @vowel
            """.trimIndent()
        )

        ch("ˈpis.ta") shouldBe "ˈpi.ta"
        ch("kam.ˈpis") shouldBe "ka.ˈpi"
    }

    "Vowel breaking should work without syllable features bleeding onto the previous syllable" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Diacritic ˈ (before) [+stress]
                
                Class consonant {p, t, k, s, m, n, l}
                Class vowel {a, ə, i, u}
                Class glide {j, w}
                
                Syllables:
                 @consonant @vowel
                
                apply-stress:
                 <syl> => [+stress] / _ <syl> $
                
                breaking:
                 {i, u}&[-stress] => {jə, wə}
                
                Syllables:
                 @consonant @glide? @vowel
            """.trimIndent()
        )

        ch("patimina") shouldBe "pa.tjə.ˈmi.na"
    }

    "We should be able to change syllable structure partway through the rules" {
        val ch = lsc(
            """
                Feature (syllable) +stress
                Diacritic ˈ (before) [+stress]
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                stress-penult:
                    <syl> => [+stress] / _ <syl> $
                syncope:
                    @vowel => * / _ <syl>&[+stress]
                Syllables:
                    (@cons // @vowel _)? @cons? @vowel @cons?
            """.trimIndent()
        )

        ch("kamina") shouldBe "ˈkmi.na"
        ch("arensa") shouldBe "ˈren.sa"
    }

    "We should be able to remove syllabification entirely by specifying \"clear\"" {
        val ch = lsc(
            """
                Feature (syllable) +stress, +vowelstress
                Diacritic ˈ (before) [+stress]
                Diacritic ́  (first) [+vowelstress]
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n, l, r}
                Syllables:
                    @cons? @vowel @cons?
                stress-penult:
                    <syl> => [+stress] / _ <syl> $
                stress-on-vowel:
                    @vowel&[+stress] => [+vowelstress]
                Syllables:
                    clear
            """.trimIndent()
        )

        ch("kalami") shouldBe "kalámi"
        ch("solkan") shouldBe "sólkan"
    }

    "Clearing syllables after an intermediate romanizer shouldn't affect the romanizer" {
        val ch = lsc(
            """
                Syllables:
                    explicit
                Romanizer-inter:
                    unchanged
                Syllables:
                    clear
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("pi.ka")) shouldBe mapOf(
            "inter" to listOf("pi.ka"),
            null to listOf("pika"),
        )

        val ch2 = lsc(
            """
                Syllables:
                    explicit
                voice:
                    {p, k} => {b, g}
                Romanizer-inter:
                    unchanged
                Syllables:
                    clear
            """.trimIndent()
        )

        ch2.changeWithIntermediates(listOf("pi.ka")) shouldBe mapOf(
            "inter" to listOf("bi.ga"),
            null to listOf("biga"),
        )
    }

    "Statements between rules should run in order" {
        val ch = lsc(
            """
                Syllables:
                    explicit
                Romanizer-a:
                    unchanged
                Syllables:
                    []
                Syllables:
                    b a
                Romanizer-b:
                    unchanged
                Syllables:
                    []
                Romanizer-c:
                    unchanged
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("baba.ba")) shouldBe mapOf(
            "a" to listOf("baba.ba"),
            "b" to listOf("ba.ba.ba"),
            "c" to listOf("b.a.b.a.b.a"),
            null to listOf("b.a.b.a.b.a"),
        )
    }

    "Stop-before should stop immediately before the rule, after the in-between statements" {
        val ch = lsc(
            """
                Syllables:
                    explicit
                Romanizer-inter:
                    unchanged
                Syllables:
                    b a
                my-rule:
                    b => n
                Syllables:
                    n a
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("bab.a"), stopBefore = "my-rule") shouldBe mapOf(
            "inter" to listOf("bab.a"),
            null to listOf("ba.ba"),
        )
    }

    "Unbounded syllable repeaters should be able to process empty words" {
        val ch = lsc(
            """
                Syllables:
                    b a
                rule:
                    <syl> => x / _ <syl> (<syl> <syl>)* $
            """.trimIndent()
        )

        ch("") shouldBe ""
    }
})