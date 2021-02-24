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
            lsc("badrule:\n   a => b [mat]")
        }.also {
            it.cause.shouldBeInstanceOf<LscInvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("a => b [mat]") of rule "badrule"
                Found 1 element ("a") on the left side of the arrow but 2 elements ("b", "[mat]") on the right side
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