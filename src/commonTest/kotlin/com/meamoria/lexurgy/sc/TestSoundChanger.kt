package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.DanglingDiacritic
import com.meamoria.mpp.kotest.*

@Suppress("unused")
class TestSoundChanger : StringSpec({
    val lsc = SoundChanger.Companion::fromLsc

    "An empty file should parse into a sound changer that returns each word unmodified" {
        val ch = lsc("")

        ch("foo") shouldBe "foo"
        ch("fgdgfggfgfggffdf") shouldBe "fgdgfggfgfggffdf"
        ch("thefiveboxingwizardsjumpquickly") shouldBe "thefiveboxingwizardsjumpquickly"
    }

    "We should be able to declare a simple character-to-character change rule" {
        val ch = lsc(
            """
                a-rule:
                x=>h
            """.trimIndent()
        )

        ch("maxel") shouldBe "mahel"
        ch("expexax") shouldBe "ehpehah"
    }

    "A file with syntax errors should fail to parse even if the start is valid" {
        shouldThrow<LscNotParsable> {
            lsc(
                """
                a-rule:
                x=>h
                ]]]]]
            """.trimIndent()
            )
        }
    }

    "We should be able to declare multiple rules in a file, executed sequentially" {
        val ch = lsc(
            """
                rule-one:
                a=>b
                rule-two:
                b=>c
            """.trimIndent()
        )

        ch("ababad") shouldBe "cccccd"
    }

    "Duplicate rules should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    duplicate-rule:
                        o => a
                    duplicate-rule:
                        a => o
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The rule \"duplicate-rule\" is defined more than once"
        }
    }

    "We should be able to declare compound rules that execute simultaneously" {
        val ch = lsc(
            """
               |chain:
               | p => f
               | f => h
               | h => *
            """.trimMargin()
        )

        ch("mapel") shouldBe "mafel"
        ch("fanoham") shouldBe "hanoam"
        ch("pehgept") shouldBe "fegeft"
    }

    "Overlapping rules should be resolved in precedence order" {
        val ch1 = lsc(
            """
               |decluster: 
               | kn => n
               | sk => k
            """.trimMargin()
        )

        ch1("skem") shouldBe "kem"
        ch1("knum") shouldBe "num"
        ch1("sknit") shouldBe "snit"

        val ch2 = lsc(
            """
               |repetitious:
               | aaab => q
               | aaa => z
               | aa => x
            """.trimMargin()
        )

        ch2("baaabaaa") shouldBe "bqz"
        ch2("baaacaaa") shouldBe "bzcz"
        ch2("baaaacaa") shouldBe "bzacx"
        ch2("baaaaaaabaaaaa") shouldBe "bzaqzx"
    }

    "Rules with mismatched elements should produce an LscInvalidRuleExpression with a clear error message" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("badrule:\n   a => b c")
        }.also {
            it.cause.shouldBeInstanceOf<LscInvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("a => b c") of rule "badrule"
                Found 1 element ("a") on the left side of the arrow but 2 elements ("b", "c") on the right side
            """.trimIndent()
        }
    }

    "Overlapping sequence rules should be resolved in precedence order" {
        val ch1 = lsc(
            """
               |decluster: 
               | k n => * n
               | s k => * k
            """.trimMargin()
        )

        ch1("skem") shouldBe "kem"
        ch1("knum") shouldBe "num"
        ch1("sknit") shouldBe "snit"

        val ch2 = lsc(
            """
               |repetitious:
               | aa a b => * q *
               | a aa => z *
               | a a => * x
            """.trimMargin()
        )

        ch2("baaabaaa") shouldBe "bqz"
        ch2("baaacaaa") shouldBe "bzcz"
        ch2("baaaacaa") shouldBe "bzacx"
        ch2("baaaaaaabaaaaa") shouldBe "bzaqzx"
    }

    "We should be able to implement deletion and epenthesis with * rules" {
        val ch = lsc(
            """
                deletion:
                    a => * / $ _
                    i => * / _ $
                    u => * / s _ s
                epenthesis:
                    * => i / $ _ d
                    * => a / _ $
                    * => u / d _ d
            """.trimIndent()
        )

        ch("afoobi") shouldBe "fooba"
        ch("dasusad") shouldBe "idassada"
        ch("muddud") shouldBe "mudududa"
    }

    "We should be able to match sounds against a simple feature matrix" {
        val ch = lsc(
            """
                Feature Manner(stop, nonstop)
                Feature Place(labial, alveolar, velar)
                Symbol p [labial stop]
                Symbol t [alveolar stop]
                Symbol k [velar stop]
                Symbol f [nonstop]
                drop-stop:
                    [stop] => *
            """.trimIndent()
        )

        ch("klaptrap") shouldBe "lara"
        ch("fniftikuf") shouldBe "fnifiuf"
    }

    "Duplicate feature declarations should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Feature Manner(stop, nonstop)
                    Feature Manner(labial, alveolar, velar)
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The feature \"Manner\" is defined more than once"
        }
    }

    "Duplicate feature value declarations should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Feature Manner(stop, stop)
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The feature value \"stop\" is defined more than once"
        }
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Feature Manner(stop, nonstop)
                    Feature Place(nonstop, alveolar, velar)
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The feature value \"nonstop\" is defined more than once"
        }
    }

    "Duplicate symbol declarations should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Feature Manner(stop, nonstop)
                    Symbol p [stop]
                    Symbol p [nonstop]
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The symbol \"p\" is defined more than once"
        }
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Feature Manner(stop, affricate)
                    Symbol ts [affricate]
                    Symbol ts, dz
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The symbol \"ts\" is defined more than once"
        }
    }

    "Multiple symbols with the same feature matrix should produce an LscDuplicateMatrices" {
        shouldThrow<LscDuplicateMatrices> {
            lsc(
                """
                    Feature Type(*cons, vowel)
                    Symbol æ [vowel]
                    Symbol ɛ [vowel]
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The symbols æ and ɛ both have the matrix [vowel]; add features to make them distinct."
        }
    }

    "We should be able to alter matrix features with a rule" {
        val ch = lsc(
            """
               |Feature Voicing(unvcd, vcd)
               |Feature Manner(stop, nonstop)
               |Symbol p [unvcd stop]
               |Symbol b [vcd stop]
               |Symbol f [unvcd nonstop]
               |Symbol v [vcd nonstop]
               |devoice-all:
               |    [vcd] => [unvcd]
            """.trimMargin()
        )

        ch("bivalve") shouldBe "pifalfe"
        ch("prefabricative") shouldBe "prefapricatife"
    }

    "We should be able to restrict changes to a specific environment" {
        val ch = lsc(
            """
               |Feature Depth(front, back)
               |Feature Place(alv, pal, vel)
               |Symbol i [front]
               |Symbol u [back]
               |Symbol t [alv]
               |Symbol tʃ [pal]
               |Symbol k [vel]
               |soft-c:
               |    [alv] => [pal] / _ [front]
               |    [vel] => [pal] / _ [front]
            """.trimMargin()
        )

        ch("kikuki") shouldBe "tʃikutʃi"
        ch("tutit") shouldBe "tutʃit"
    }

    "We should be able to prevent changes from happening in a specific environment" {
        val ch1 = lsc(
            """
               |simple:
               |    k => x / a _ // _ a
               |complex:
               |    p => f / {a _, e _} // {_ a, _ e}
            """.trimMargin()
        )

        ch1("akakekak") shouldBe "akaxekax"
        ch1("apapepipapu") shouldBe "apapefipafu"

        val ch2 = lsc(
            """
               |Feature Manner(stop, fric)
               |Feature Place(lab, alv, vel)
               |Symbol p [stop lab]
               |Symbol t [stop alv]
               |Symbol k [stop vel]
               |Symbol f [fric lab]
               |Symbol s [fric alv]
               |Symbol x [fric vel]
               |different-stops:
               |    [stop ${'$'}Place] => [fric] / _ [stop] // _ [${'$'}Place]
            """.trimMargin()
        )

        ch2("aptekpa") shouldBe "aftexpa"
        ch2("atteppa") shouldBe "atteppa"
    }

    "A change should still proceed even if its environment is also changing" {
        val ch = lsc(
            """
                dissimilate:
                e => i / e _
                i => e / i _
            """.trimIndent()
        )

        ch("beeeeeeee") shouldBe "beiiiiiii"
        ch("beeiieeii") shouldBe "beiieeiie"
    }

    "Multiple-character symbols should be recognized as single symbols" {
        val ch = lsc(
            """
               |Feature Place(lab, apic)
               |Feature Manner(stop, sonor)
               |Feature Nasal(unnas, nas)
               |Symbol b [lab stop unnas]
               |Symbol ᵐb [lab stop nas]
               |Symbol w [lab sonor unnas]
               |Symbol m [lab sonor nas]
               |Symbol d [apic stop unnas]
               |Symbol ⁿd [apic stop nas]
               |Symbol l [apic sonor unnas]
               |Symbol n [apic sonor nas]
               |sonorize:
               |    [stop] => [sonor] / a _ a
            """.trimMargin()
        )

        ch("babaⁿdade") shouldBe "bawanade"
        ch("baᵐbaⁿdebada") shouldBe "bamaⁿdebala"
    }

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

        ch("tˈewtáj") shouldBe "tˈuwtʃéj"
        ch("tˈájtaj") shouldBe "tˈu̘jtʃej"
        ch("tˈuitui") shouldBe "tˈútú"
    }

    "We should be able to use & to join two matchers" {
        val ch = lsc(
            """
                Feature Stressed(*unstressed, stressed)
                Diacritic ˈ [stressed]
                Class vowel {a, e, i, o, u}
                
                Deromanizer:
                    {á, é, í, ó, ú} => {aˈ, eˈ, iˈ, oˈ, uˈ}
                
                unstressed-final-vowel-loss:
                    @vowel&[unstressed] => * / _ ${'$'} // {p, t, k} _
                
                Romanizer:
                    {aˈ, eˈ, iˈ, oˈ, uˈ} => {á, é, í, ó, ú}
            """.trimIndent()
        )

        ch("páno") shouldBe "pán"
        ch("panó") shouldBe "panó"
        ch("pánt") shouldBe "pánt"
        ch("páko") shouldBe "páko"

        val ch2 = lsc(
            """
                Feature Stressed(*unstressed, stressed)
                Diacritic ˈ (floating) [stressed]

                unstressed-vowel-centralizing:
                    {e, i, o, u}&[unstressed] => {ə, ɨ, ə, ɨ}
            """.trimIndent()
        )

        ch2("paˈno") shouldBe "paˈnə"
        ch2("iniˈte") shouldBe "ɨniˈtə"

        val ch3 = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class cons {p, t, k, s, m, n}
                Class stop {p, t, k}
                
                final-vowel-loss:
                    @vowel => * / @vowel @cons&!@stop _ $
            """.trimIndent()
        )

        ch3("pano") shouldBe "pan"
        ch3("pako") shouldBe "pako"
        ch3("pao") shouldBe "pao"
    }

    "We should be able to copy a feature value out of an intersection" {
        val ch = lsc(
            """
                Feature Voicing(unvoiced, voiced)
                Feature Nasality(*nonnasal, nasal)
                Feature Place(labial, alveolar, velar, glottal)
                Feature Manner(stop, fricative, approximant)

                Symbol p [unvoiced labial stop]
                Symbol b [voiced labial stop]
                Symbol k [unvoiced velar stop]
                Symbol g [voiced velar stop]
                Symbol f [unvoiced labial fricative]
                Symbol v [voiced labial fricative]
                Symbol n [voiced nasal alveolar]
                Symbol m [voiced nasal labial]
                Symbol r [voiced approximant]

                Class vowel {a, i, e, o, u}
                Class cons {p, b, k, g, f, v, r}

                nasal-assimilation:
                [nasal] => [${'$'}Place] / _ @cons&[${'$'}Place]

                obstruent-voicing-assimilation:
                @cons&!r => [${'$'}Voicing] / _ @cons&[${'$'}Voicing]
            """.trimIndent()
        )

        ch("anpara") shouldBe "ampara"
        ch("aprirka") shouldBe "abrirka"
        ch("avpika") shouldBe "afpika"
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

        ch("tˈewtáj") shouldBe "tˈuwtʃéj"
        ch("tˈájtaj") shouldBe "tˈu̘jtʃej"
        ch("tˈuitui") shouldBe "tˈútú"
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
        ch("tájtaj") shouldBe "tájtej"
    }

    "We should be able to rename the \"absent\" value of a feature" {
        val ch = lsc(
            """
               |Feature Manner(stop)
               |Feature Place(lab, apic, vel)
               |Feature Breath(*plain, aspir)
               |Diacritic ʰ [aspir]
               |Symbol p [stop lab]
               |Symbol t [stop apic]
               |Symbol k [stop vel plain]
               |aspiration:
               |    [stop plain] s => [aspir] *
               |lenition:
               |    [stop aspir] => [plain] / a _ a
               |    [stop plain] => * / a _ a
               |velar-shift:
               |    [stop] => [vel] / _ u
            """.trimMargin()
        )

        ch("psataba") shouldBe "pʰaaba"
        ch("patsaba") shouldBe "pataba"
        ch("putsu") shouldBe "kukʰu"
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

        ch("kaki") shouldBe "káki"
        ch("putatu") shouldBe "pútatu"
        ch("ichigaku") shouldBe "íchigaku"
        ch("epistrefu") shouldBe "épistrefu"
    }

    "We should be able to mark the word boundary with a $" {
        val ch1 = lsc(
            """
               |boundary-h-drop:
               |    h => * / $ _
               |    h => * / _ $
            """.trimMargin()
        )

        ch1("hahahahah") shouldBe "ahahaha"

        val ch2 = lsc(
            """
               |overly-specific:
               |    a => e / $ b _ t $
            """.trimMargin()
        )

        ch2("bat") shouldBe "bet"
        ch2("abat") shouldBe "abat"
        ch2("bata") shouldBe "bata"
        ch2("cat") shouldBe "cat"
    }

    "We should be able to write compact changes with alternative lists" {
        val ch = lsc(
            """
                vowel-shift:
                {o, u} => {u, y}
                {i, e} => {e, a} / _ {m, n}
            """.trimIndent()
        )

        ch("botu") shouldBe "buty"
        ch("tintin") shouldBe "tenten"
        ch("tenpin") shouldBe "tanpen"
        ch("mitochondrion") shouldBe "mituchundriun"
    }

    "Word boundaries should work inside alternative lists" {
        val ch = lsc(
            """
                Class cons {p, t, k, s, m, n, l}
                nasalization:
                    {an, en, on} => {ã, ẽ, õ} / _ {$, @cons}
            """.trimIndent()
        )

        ch("pant") shouldBe "pãt"
        ch("sen") shouldBe "sẽ"
        ch("senon") shouldBe "senõ"
        ch("senont") shouldBe "senõt"
        ch("senonet") shouldBe "senonet"

        val ch2 = lsc(
            """
                Feature Type(cons, vowel)
                Symbol t [cons]
                Symbol a [vowel]
                crazy:
                    a => e / {[cons] [vowel], $ [cons]} [vowel] [cons] _
            """.trimIndent()
        )

        ch2("tata") shouldBe "tate"
        ch2("ataatata") shouldBe "ataateta"
    }

    "Misplaced word boundaries should result in an LscInteriorWordBoundary" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("foo:\no => a / _ $ o")
        }.also {
            it.cause.shouldBeInstanceOf<LscInteriorWordBoundary>()
            it.message shouldBe """
                Error in expression 1 ("o => a / _ $ o") of rule "foo"
                A word boundary in "$ o" in the environment "_ $ o" needs to be at the beginning or end
            """.trimIndent()
        }
        shouldThrow<LscInvalidRuleExpression> {
            lsc("foo:\no => a / $ e _ {a, i {$ o, o $}, e $}")
        }.also {
            it.cause.shouldBeInstanceOf<LscInteriorWordBoundary>()
            it.message shouldBe """
                Error in expression 1 ("o => a / $ e _ {a, i {$ o, o $}, e $}") of rule "foo"
                A word boundary in "$ o" in the environment "$ e _ {a, i {$ o, o $}, e $}" needs to be at the beginning or end
            """.trimIndent()
        }
    }

    "We should be able to match repeated segments" {
        val ch = lsc(
            """
                umlaut:
                {a, e, u} => {e, i, y} / _ {m, n}+ i {m, n}* $
            """.trimIndent()
        )

        ch("anni") shouldBe "enni"
        ch("uim") shouldBe "uim"
        ch("unim") shouldBe "ynim"
        ch("enmnenmni") shouldBe "enmninmni"
    }

    "We should be able to change repeaters into things" {
        val ch = lsc(
            """
                Feature Height(low, high)
                Symbol a [low]
                Symbol i [high]
                any-number-of-i-to-j:
                    i+ => j / k _ a
                any-number-of-a-all-high:
                    a+ => [high] / t _
                s-palatal-and-swallow-c:
                    s c? => ʃ * / _ i
            """.trimIndent()
        )

        ch("kiiia") shouldBe "kja"
        ch("taaaaba") shouldBe "tiiiiba"
        ch("sciensia") shouldBe "ʃienʃia"
    }

    "But we shouldn't be able to put repeaters on the output side" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("foo:\no => a+ / _ a")
        }
    }

    "Repeated segments on the edge of a rule should result in an LscPeripheralRepeater" {
        shouldThrow<LscInvalidRuleExpression> {
            lsc("foo:\no => a / _ a*")
        }.also {
            it.cause.shouldBeInstanceOf<LscPeripheralRepeater>()
            it.message shouldBe """
                Error in expression 1 ("o => a / _ a*") of rule "foo"
                The repeater "a*" in the environment "_ a*" is meaningless because it's at the edge of the environment; remove it
            """.trimIndent()
        }
        shouldThrow<LscInvalidRuleExpression> {
            lsc("foo:\no => a / f+ _")
        }.also {
            it.cause.shouldBeInstanceOf<LscPeripheralRepeater>()
            it.message shouldBe """
                Error in expression 1 ("o => a / f+ _") of rule "foo"
                The repeater "f+" in the environment "f+ _" is meaningless because it's at the edge of the environment; just use "f"
            """.trimIndent()
        }
    }

    "We should be able to specify multiple possible environments for a change" {
        val ch1 = lsc(
            """
                boundary-h-drop:
                h => * / {$ _, _ $}
            """.trimIndent()
        )

        ch1("hahahahah") shouldBe "ahahaha"

        val ch2 = lsc(
            """
                fancy-frication:
                {p, t, k} => {f, ts, x} / {_ a, {a, e, i, o, u} _ {e, i, o, u}}
            """.trimIndent()
        )

        ch2("patika") shouldBe "fatsixa"
        ch2("topeka") shouldBe "tofexa"
        ch2("tentaklop") shouldBe "tentsaklop"
    }

    "A negated matrix value should only match sounds that don't have that feature value" {
        val ch = lsc(
            """
                Feature Place(lab, alv, glot)
                Feature Voicing(unvcd, vcd)
                Symbol f [unvcd lab]
                Symbol v [vcd lab]
                Symbol s [unvcd alv]
                Symbol z [vcd alv]
                Symbol h [unvcd glot]
                h-is-special:
                [unvcd !glot] => [vcd] / a _ a
            """.trimIndent()
        )

        ch("ahafasa") shouldBe "ahavaza"

        shouldThrow<LscInvalidRuleExpression> {
            lsc("negated-in-output:\n[foo] => [!bar]")
        }.also {
            it.cause.shouldBeInstanceOf<LscInvalidOutputMatrix>()
            it.message shouldBe """
                Error in expression 1 ("[foo] => [!bar]") of rule "negated-in-output"
                Feature matrix [!bar] has a negated feature, which isn't allowed in the output of a rule
            """.trimIndent()
        }
    }

    "An absent feature value should only match sounds that don't have any value from that feature" {
        val ch = lsc(
            """
                Feature Type(cons)
                Feature Manner(stop, fric, nas)
                Feature Voicing(unvcd, vcd)
                Symbol t [cons stop unvcd]
                Symbol d [cons stop vcd]
                Symbol n [cons nas]
                stop-to-nasal:
                [stop] => [nas *Voicing] / a _ a
                drop-nasal:
                [cons *Voicing] => * / _ [stop]
            """.trimIndent()
        )

        ch("antata") shouldBe "atana"
        ch("adtata") shouldBe "adtana"
    }

    "We should be able to copy feature variables from one matrix to another using feature variables" {
        val ch1 = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(low, high)
                Feature Depth(front, back)
                Symbol a [vowel low back]
                Symbol e [vowel low front]
                Symbol o [vowel high back]
                Symbol i [vowel high front]
                short-harmony:
                [vowel] => [${'$'}Height] / [${'$'}Height] n+ _
                [vowel ${'$'}Height ${'$'}Depth] => * / [vowel ${'$'}Height ${'$'}Depth] _
            """.trimIndent()
        )

        ch1("anni") shouldBe "anne"
        ch1("inna") shouldBe "inno"
        ch1("beetaamae") shouldBe "betamae"

        val ch2 = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(low, high)
                Feature Depth(front, back)
                Feature Rounding(round, unround)
                Symbol a [vowel low back unround]
                Symbol o [vowel low back round]
                Symbol e [vowel low front unround]
                Symbol ö [vowel low front round]
                Symbol ï [vowel high back unround]
                Symbol u [vowel high back round]
                Symbol i [vowel high front unround]
                Symbol ü [vowel high front round]
                coalescence:
                {[vowel ${'$'}Rounding ${'$'}Height] [high ${'$'}Depth], [high ${'$'}Depth] [vowel ${'$'}Rounding ${'$'}Height]} => [${'$'}Rounding ${'$'}Depth ${'$'}Height] *
            """.trimIndent()
        )

        ch2("duomaitio") shouldBe "dometö"
    }

    "Feature variables should capture a feature's default value" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(*low, high)
                Feature Depth(*front, back)

                Symbol a [vowel back]
                Symbol e [vowel]
                Symbol i [vowel high]
                Symbol u [vowel high back]

                harmony [vowel] propagate:
                    [] => [${'$'}Height] / [${'$'}Height] _
            """.trimIndent()
        )

        ch("kaki") shouldBe "kake"
        ch("putatu") shouldBe "pututu"
        ch("ichigaku") shouldBe "ichiguku"
        ch("epistrefu") shouldBe "epestrefa"
    }

    "We should be able to use feature variables to conjure a matrix out of nothing" {
        val ch = lsc(
            """
                Feature Place(labial, alveolar, velar)
                Feature Manner(stop, nasal)
                Symbol p [labial stop]
                Symbol t [alveolar stop]
                Symbol k [velar stop]
                Symbol m [labial nasal]
                Symbol n [alveolar nasal]
                Symbol ŋ [velar nasal]
                interpolate:
                    * => [${'$'}Place stop] / [${'$'}Place nasal] _ [stop]
            """.trimIndent()
        )

        ch("klomter") shouldBe "klompter"
        ch("sfiŋter") shouldBe "sfiŋkter"
        ch("bumkin") shouldBe "bumpkin"
    }

    "We should be able to define reusable alternative lists as sound classes" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                Class unvcdstop {p, t, k}
                Class vcdstop {b, d, g}
                intervocalic-lenition:
                @unvcdstop => @vcdstop / @vowel _ @vowel
            """.trimIndent()
        )

        ch("apetiko") shouldBe "abedigo"
        ch("aptiko") shouldBe "aptigo"
    }

    "Duplicate class declarations should produce an LscDuplicateName" {
        shouldThrow<LscDuplicateName> {
            lsc(
                """
                    Class foo {a, b, c}
                    Class foo {d, e, f}
                """.trimIndent()
            )
        }.also {
            it.message shouldBe "The class \"foo\" is defined more than once"
        }
    }

    "We should be able to use previous class definitions in classes" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class fricative {f, s}
                Class obstruent {@stop, @fricative}
                drop-final-obstruent:
                    @obstruent => * / _ $
            """.trimIndent()
        )

        ch("ararat") shouldBe "arara"
        ch("ananas") shouldBe "anana"
        ch("bananal") shouldBe "bananal"
    }

    "We should be able to match segments that don't belong to a particular class" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class vowel {a, e, i, o, u}
                final-vowel-loss:
                    @vowel => * / !@stop _ $
            """.trimIndent()
        )

        ch("buka") shouldBe "buka"
        ch("suna") shouldBe "sun"
        ch("puraa") shouldBe "pura"
    }

    "We should be able to implement gemination and degemination with captures" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class fricative {f, s, x}
                stop-gemination:
                h @stop$1 => $1 $1
                fricative-degemination:
                @fricative$1 => * / _ $1
            """.trimIndent()
        )

        ch("ahpessi") shouldBe "appesi"
        ch("ifsehkasxo") shouldBe "ifsekkasxo"
    }

    "We should be able to implement gemination and degemination with matrix captures" {
        val ch = lsc(
            """
                Feature Manner(stop, fricative)
                Feature Place(labial, alveolar, velar)
                Symbol p [labial stop]
                Symbol t [alveolar stop]
                Symbol k [velar stop]
                Symbol f [labial fricative]
                Symbol s [alveolar fricative]
                Symbol x [velar fricative]
                stop-gemination:
                h [stop]$1 => $1 $1
                fricative-degemination:
                [fricative]$1 => * / _ $1
            """.trimIndent()
        )

        ch("ahpessi") shouldBe "appesi"
        ch("ifsehkasxo") shouldBe "ifsekkasxo"
        // Tests that we don't get crashes if the rule is looking for a geminate off the end of the word.
        ch("affes") shouldBe "afes"
    }

    "We should be able to implement metathesis with captures" {
        val ch = lsc(
            """
                Class stop {p, t, k}
                Class fricative {f, s, x}
                Class vowel {a, e, i, o, u}
                metathesis:
                @stop$1 @fricative$2 => $2 $1 / @vowel _ @vowel
            """.trimIndent()
        )

        ch("taksidepsi") shouldBe "taskidespi"
        ch("fnitficuts") shouldBe "fnifticuts"
    }

    "Capturing multiple things with the same capture number should result in a LscReboundCapture" {
        shouldThrow<LscRuleNotApplicable> {
            val ch = lsc(
                """
                Class stop {p, t, k}
                double-stop-epenthesis:
                    * => i / _ @stop$1 @stop$1
                """.trimIndent()
            )
            ch("ppa")
        }.also {
            it.cause.shouldBeInstanceOf<LscReboundCapture>()
            it.message shouldBe
                    "Rule double-stop-epenthesis could not be applied to word ppa (originally ppa)\n" +
                    "Capture variable 1 is bound more than once; " +
                    "replace the second with a capture reference (\"${'$'}1\")"
        }
    }

    "We should be able to negate plain text and capture references" {
        val ch = lsc(
            """
                Class vowel {a, e, i, o, u}
                
                i-before-e:
                    i => * / !c _ e
                
                not-the-same:
                    {i, u}$1 => {j, w} / _ @vowel&!$1
            """.trimIndent()
        )

        ch("cietua") shouldBe "cjetwa"
        ch("vietuu") shouldBe "vetuu"
    }

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

    "A rule with a filter should only operate on sounds that pass the filter" {
        val ch = lsc(
            """
                Feature Height(low, high)
                Feature Depth(front, back)
                Symbol a [low back]
                Symbol e [low front]
                Symbol o [high back]
                Symbol i [high front]
                harmony [front]:
                [] => [${'$'}Height] / [${'$'}Height] _
                echo-deletion [back]:
                [${'$'}Height] [${'$'}Height] => [front] *
                fancy-breaking [high]:
                i => ai / o _
            """.trimIndent()
        )

        ch("enni") shouldBe "enne"
        ch("onna") shouldBe "onna"
        ch("ibstveki") shouldBe "ibstvike"

        ch("onno") shouldBe "inn"
        ch("onni") shouldBe "onnai"

        shouldThrow<LscInvalidRuleExpression> {
            lsc("harmony [vowel]:\n[low] * => [high] a")
        }.also {
            it.cause.shouldBeInstanceOf<LscInvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("[low] * => [high] a") of rule "harmony"
                Asterisks aren't allowed on the match side of filtered rules
            """.trimIndent()
        }
        shouldThrow<LscInvalidRuleExpression> {
            lsc("harmony [vowel]:\n[low] ai => [high] a")
        }.also {
            it.cause.shouldBeInstanceOf<LscInvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("[low] ai => [high] a") of rule "harmony"
                Multi-segment matches aren't allowed on the match side of filtered rules
            """.trimIndent()
        }
        shouldNotThrowAny { lsc("Symbol ai\nharmony [vowel]:\n[low] ai => [high] a") }
    }

    "Negated features should be usable in filters" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(low, mid, high)
                Feature Depth(front, back)
                Symbol æ [low front vowel]
                Symbol e [mid front vowel]
                Symbol i [high front vowel]
                Symbol ɑ [low back vowel]
                Symbol o [mid back vowel]
                Symbol u [high back vowel]
                harmony [vowel !low]:
                    [] => [${'$'}Depth] / [${'$'}Depth] _
            """.trimIndent()
        )

        ch("pinoki") shouldBe "pineku"
        ch("pinɑku") shouldBe "pinɑki"
    }

    "Classes should be usable as filters" {
        val ch = lsc(
            """
                Class low {a, e}
                Class high {o, i}
                Class front {e, i}
                Class back {a, o}
                harmony @front:
                    @high => @low / @low _
                    @low => @high / @high _
            """.trimIndent()
        )

        ch("enni") shouldBe "enne"
        ch("onna") shouldBe "onna"
        ch("ibstveki") shouldBe "ibstvike"
    }

    "Overlapping rules in a filter rule should be resolved in precedence order" {
        val ch = lsc(
            """
                Feature Type(vowel)
                Feature Height(low, mid, high)
                Symbol a [vowel low]
                Symbol e [vowel mid]
                Symbol i [vowel high]
                levelling [vowel]:
                a i => e e
                i a => e e
            """.trimIndent()
        )

        ch("hapi") shouldBe "hepe"
        ch("hapipa") shouldBe "hepepa"
        ch("hipapi") shouldBe "hipepe"
    }

    "A propagating rule should be applied repeatedly until the word stabilizes" {
        val ch1 = lsc(
            """
                Feature Height(low, high)
                Feature Depth(front, back)
                Feature Rounding(unrnd, rnd)
                Feature Type(cons, vowel)
                Symbol a [vowel low back unrnd]
                Symbol e [vowel low front unrnd]
                Symbol o [vowel low back rnd]
                Symbol ø [vowel low front rnd]
                Symbol ɨ [vowel high back unrnd]
                Symbol i [vowel high front unrnd]
                Symbol u [vowel high back rnd]
                Symbol y [vowel high front rnd]
                harmony-forward [vowel] propagate:
                [] => [${'$'}Depth] / [${'$'}Depth] _
                harmony-backward propagate [vowel]:
                [] => [${'$'}Rounding] / _ [${'$'}Rounding]
            """.trimIndent()
        )

        ch1("enotahu") shouldBe "ønøtøhy"
        ch1("ypatoka") shouldBe "ipeteke"

        val ch2 = lsc(
            """
                bouncing propagate:
                a => e / b _
                e => a / _ d
            """.trimIndent()
        )

        val ex = shouldThrow<LscRuleNotApplicable> { ch2("bed") }
        ex.cause.shouldBeInstanceOf<LscDivergingPropagation>()
    }

    "A deromanizer should convert plain words to phonetic, and a romanizer should do the opposite" {
        val ch = lsc(
            """
                Feature Type(cons, vowel)
                Feature Depth(front, central, back)
                Symbol a [vowel central]
                Symbol i [vowel front]
                Symbol u [vowel back]
                Deromanizer:
                sh => ʃ
                sh-loss:
                ʃ => s
                Romanizer:
                k => qu / _ [front]
                k => c
                f => v / [vowel] _ [vowel]
            """.trimIndent()
        )

        ch("shaki") shouldBe "saqui"
        ch("kafash") shouldBe "cavas"
    }

    "Deromanizers and romanizers should be able to have additional phonetic rules that apply on the phonetic side" {
        val ch = lsc(
            """
                Feature Type(vowel, cons)
                Feature Height(low, high)
                Feature Depth(front, back)
                Feature Stress(*unstressed, stressed)
                Feature Length(*short, long)
                Diacritic ˈ (before) [stressed]
                Diacritic ː [long]
                Symbol a [vowel low back]
                Symbol e [vowel low front]
                Symbol u [vowel high back]
                Symbol i [vowel high front]
                Symbol tʃ
                Deromanizer:
                    sh => ʃ
                    ch => tʃ
                    Then:
                    [vowel] => [stressed] / $ [!vowel]? _
                palatal-shift:
                    tʃ => ʃ
                    ʃ => s
                stress-lengthen:
                    [vowel stressed] => [long]
                stress-shift:
                    [stressed] => [unstressed]
                    Then: [vowel] => [stressed] / _ [!vowel]? $
                Romanizer:
                    [long]${"$"}1 * => ${"$"}1 ${"$"}1
                    then:
                    [long] => [short]
                    then:
                    ʃ => sh
                    {ˈa, ˈe, ˈu, ˈi} => {á, é, ú, í}
                    
            """.trimIndent()
        )

        ch("shamu") shouldBe "saamú"
        ch("arima") shouldBe "aarimá"
        ch("chamek") shouldBe "shaamék"
    }

    "Deromanizers and romanizers should default to all-phonetic" {
        shouldThrow<DanglingDiacritic> {
            lsc(
                """
                    Diacritic ' [ejective]
                    Deromanizer:
                        ' => ʔ
                """.trimIndent()
            )
        }
        shouldThrow<DanglingDiacritic> {
            lsc(
                """
                    Diacritic ' [ejective]
                    Romanizer:
                        ʔ => '
                """.trimIndent()
            )
        }
        shouldThrow<DanglingDiacritic> {
            lsc(
                """
                    Diacritic ' [ejective]
                    Romanizer-foo:
                        ʔ => '
                """.trimIndent()
            )
        }
    }

    "Deromanizers and romanizers marked 'literal' should ignore declarations" {
        val ch = lsc(
            """
                Diacritic ' [ejective]
                Deromanizer literal:
                    ' => ʔ
                Romanizer literal:
                    ʔ => '
            """.trimIndent()
        )

        ch("ma'a") shouldBe "ma'a"
    }

    "The matrix to symbol converter should still work if some symbols don't have features" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(low, high)
                Feature Depth(front, back)
                Feature Stress(*unstr, str)
                Diacritic ˈ (before) [str]
                Symbol a [vowel low]
                Symbol i [vowel high front]
                Symbol u [vowel high back]
                Symbol ts, dz
                stress-shift [vowel]:
                [vowel] => [str] / _ [] $
            """.trimIndent()
        )

        ch("vlimura") shouldBe "vlimˈura"
    }

    "Symbols with no features should count as lacking all features (and having all nulls)" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                coda-h:
                h => * / _ [cons]
            """.trimIndent()
        )

        ch("sohko") shouldBe "soko"
    }

    "Running with intermediate romanizers should produce multiple result lists" {
        val ch = lsc(
            """
                Deromanizer:
                ch => tʃ
                change-a:
                tʃ => ʃ
                Romanizer-a:
                ʃ => sh
                change-b:
                a => æ
                Romanizer-b:
                ʃ => x
                æ => aa
                change-final:
                ʃ => s
                Romanizer:
                æ => ä
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("chachi", "vanechak")) shouldBe mapOf(
            "a" to listOf("shashi", "vaneshak"),
            "b" to listOf("xaaxi", "vaanexaak"),
            null to listOf("säsi", "vänesäk"),
        )
    }

    "We should be able to have several romanizers with no rules between them" {
        val ch = lsc(
            """
                Deromanizer:
                ch => tʃ
                change:
                tʃ => ʃ
                Romanizer-a:
                ʃ => sh
                Romanizer-b:
                ʃ => x
                Romanizer:
                ʃ => si
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("chachi", "vanechak")) shouldBe mapOf(
            "a" to listOf("shashi", "vaneshak"),
            "b" to listOf("xaxi", "vanexak"),
            null to listOf("siasii", "vanesiak"),
        )

        val ch2 = lsc(
            """
                Deromanizer:
                ch => tʃ
                change:
                tʃ => ʃ
                Romanizer-a:
                ʃ => sh
                Romanizer-b:
                ʃ => x
                change-final:
                a => æ
                Romanizer:
                ʃ => si
                æ => ä
            """.trimIndent()
        )

        ch2.changeWithIntermediates(listOf("chachi", "vanechak")) shouldBe mapOf(
            "a" to listOf("shashi", "vaneshak"),
            "b" to listOf("xaxi", "vanexak"),
            null to listOf("siäsii", "vänesiäk"),
        )
    }

    "The special rule 'unchanged' should do nothing" {
        val ch = lsc(
            """
                Deromanizer:
                    unchanged
                    Then:
                    ch => tʃ
                nothing:
                    unchanged
                nothing-and-something:
                    unchanged
                    tʃ => ʃ
                Romanizer-phonetic:
                    unchanged
                something:
                    a => æ
                Romanizer:
                    ʃ => sh
                    æ => ä
            """.trimIndent()
        )

        ch.changeWithIntermediates(listOf("chachi", "vanechak")) shouldBe mapOf(
            "phonetic" to listOf("ʃaʃi", "vaneʃak"),
            null to listOf("shäshi", "väneshäk"),
        )
    }

    "Spaces in a line should delimit separate words" {
        val ch = lsc(
            """
                drop-final-t:
                    t => * / _ $
            """.trimIndent()
        )

        ch("sit amet") shouldBe "si ame"
    }

    "We should be able to delete the $$ token to join words together" {
        val ch = lsc(
            """
                Feature Stress(*unstressed, stressed)
                Diacritic ˈ (floating) [stressed]
                Class vowel {a, e, i, o, u}
                
                stress-first-syllable @vowel:
                    @vowel => [stressed] / $ _
                
                stress-raising:
                    {eˈ, oˈ} => {iˈ, uˈ}
                
                tapping:
                    t => ɾ / @vowel _ @vowel
                
                glomination:
                    $$ => *
                    Then:
                    [stressed] => [unstressed] / [stressed] [unstressed]* _
                
                intervocalic-lenition:
                    {p, t, k} => {b, d, g} / @vowel _ @vowel
            """.trimIndent()
        )

        ch("sit amet") shouldBe "siˈdamet"
        ch("ko peko") shouldBe "kuˈbigo"
        ch("mate kupo tonumeka") shouldBe "maˈɾegubodunumega"
    }

    "The file format should be fairly robust to extra newlines and blank lines" {
        // We're just testing that these don't throw exceptions
        lsc("Deromanizer:\n    y => j\n")
        lsc("Deromanizer:\n\ty => j\nrule:\n    j => ʒ\n\n\n")("yay") shouldBe "ʒaʒ"
        lsc("   ")
        lsc("\n\n  \nDeromanizer:\n\t\n y => j\nrule:\n  \n   j => ʒ\n\n          ")
        lsc(
            """
                rule:
                    p => b
                # Pointless comment
                    t => d # End of line pointless comment
                    # Indented pointless comment
                    k => g
            """.trimIndent()
        )
    }

    "The file format should allow spaces to be included or not in places where this doesn't affect the meaning" {
        // We're just testing that these don't throw exceptions
        lsc("Feature Stress (*unstressed, stressed)")
    }

    "We should be able to use reserved characters in literal text by escaping them with a backslash" {
        val ch = lsc(
            """
                Feature Type(cons, vowel)
                Feature Voicing(unvoiced, voiced)
                Symbol t [cons unvoiced]
                Symbol d [cons voiced]
                Symbol \@ [vowel]
                Class swirly {\@}
                Deromanizer:
                    \+ => t
                    a => \@
                intervocalic-lenition:
                    [unvoiced] => [voiced] / [vowel] _ [vowel]
                no-swirly:
                    @swirly => i
                Romanizer:
                    d => \\
                    i => \_
            """.trimIndent()
        )

        ch("a+a+a") shouldBe "_\\_\\_"
    }
})