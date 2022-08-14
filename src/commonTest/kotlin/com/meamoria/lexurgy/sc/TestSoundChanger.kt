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

    "We should be able to have numbers in names, as long as the whole name isn't numbers" {
        lsc(
            """
                Feature 2fast(2furious)
                Class v0w3l {a, i, u}
                4tition-1:
                    b => p
            """.trimIndent()
        )
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

    "We can break rules across lines at =>" {
        val ch = lsc(
            """
                rule:
                    a =>
                    b
            """.trimIndent()
        )

        ch("ara") shouldBe "brb"
    }

    "We can break rules across lines at /" {
        val ch = lsc(
            """
                rule:
                    a => b /
                        _ c
            """.trimIndent()
        )

        ch("aca") shouldBe "bca"
    }

    "We can't break rules across blank lines" {
        shouldThrow<LscNotParsable> {
            lsc(
                """
                    rule:
                        a =>
                        
                        b
                """.trimIndent()
            )
        }
    }

    "We can't break rules across lines inside sequences" {
        shouldThrow<LscNotParsable> {
            lsc(
                """
                    rule:
                        a
                        b => c
                """.trimIndent()
            )
        }
    }

    "We can't break rules across lines inside alternative lists" {
        shouldThrow<LscNotParsable> {
            lsc(
                """
                    rule:
                        {a,
                        b} => c
                """.trimIndent()
            )
        }
    }

    "We can break class declarations at commas and the opening brace" {
        val ch = lsc(
            """
                Class letter {
                    a, b, c, d, e, f, g, h, i, j, k, l, m,
                    n, o, p, q, r, s, t, u, v, w, x, y, z,
                }
                
                destroy-letters:
                    @letter => *
            """.trimIndent()
        )

        ch("1a2x3") shouldBe "123"
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
            lsc("Feature bad(mat)\nbadrule:\n   a => b [mat]")
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
            lsc("Feature bad(vowel, low, high)\nharmony [vowel]:\n[low] * => [high] a")
        }.also {
            it.cause.shouldBeInstanceOf<LscInvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("[low] * => [high] a") of rule "harmony"
                Asterisks aren't allowed on the match side of filtered rules
            """.trimIndent()
        }
        shouldThrow<LscInvalidRuleExpression> {
            lsc("Feature bad(vowel, low, high)\nharmony [vowel]:\n[low] ai => [high] a")
        }.also {
            it.cause.shouldBeInstanceOf<LscInvalidTransformation>()
            it.message shouldBe """
                Error in expression 1 ("[low] ai => [high] a") of rule "harmony"
                Multi-segment matches aren't allowed on the match side of filtered rules
            """.trimIndent()
        }
        shouldNotThrowAny {
            lsc("Feature bad(vowel, low, high)\nSymbol ai\nharmony [vowel]:\n[low] ai => [high] a")
        }
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
        shouldThrow<LscInvalidRuleExpression> {
            lsc(
                """
                    Feature +ejective
                    Diacritic ' [+ejective]
                    Deromanizer:
                        ' => ʔ
                """.trimIndent()
            )
        }.also { it.reason.shouldBeInstanceOf<DanglingDiacritic>() }
        shouldThrow<LscInvalidRuleExpression> {
            lsc(
                """
                    Feature +ejective
                    Diacritic ' [+ejective]
                    Romanizer:
                        ʔ => '
                """.trimIndent()
            )
        }.also { it.reason.shouldBeInstanceOf<DanglingDiacritic>() }
        shouldThrow<LscInvalidRuleExpression> {
            lsc(
                """
                    Feature +ejective
                    Diacritic ' [+ejective]
                    Romanizer-foo:
                        ʔ => '
                """.trimIndent()
            )
        }.also { it.reason.shouldBeInstanceOf<DanglingDiacritic>() }
    }

    "Deromanizers and romanizers marked 'literal' should ignore declarations" {
        val ch = lsc(
            """
                Feature +ejective
                Diacritic ' [+ejective]
                Deromanizer literal:
                    ' => ʔ
                Romanizer literal:
                    ʔ => '
            """.trimIndent()
        )

        ch("'ama") shouldBe "'ama"
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

    "Setting romanize = false should make all romanizers dump phonetic forms" {
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

        ch.changeWithIntermediates(listOf("chachi", "vanechak"), romanize = false) shouldBe mapOf(
            "a" to listOf("ʃaʃi", "vaneʃak"),
            "b" to listOf("ʃaʃi", "vaneʃak"),
            null to listOf("ʃaʃi", "vaneʃak"),
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

    "We can have leading spaces at the beginning of the file" {
        val ch = lsc("    rule:\na => b")

        ch("aaa") shouldBe "bbb"
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

    "We should be able to use keywords as literal text and parts of rule names" {
        val ch = lsc(
            """
                ltr-to-ch:
                    ltr => tʃ
            """.trimIndent()
        )

        ch("eltrun") shouldBe "etʃun"

        val ch2 = lsc(
            """
                syllables-are-syllables:
                    o => syllables
            """.trimIndent()
        )

        ch2("foo") shouldBe "fsyllablessyllables"

        val ch3 = lsc(
            """
                class-feature-diacritic-symbol:
                    {class, feature} => {diacritic, symbol}
            """.trimIndent()
        )

        ch3("featureymcclassington") shouldBe "symbolymcdiacriticington"

        val ch4 = lsc(
            """
                clear-explicit:
                    clear => explicit
            """.trimIndent()
        )

        ch4("oooclearooo") shouldBe "oooexplicitooo"

        val ch5 = lsc(
            """
                deromanizer-romanizer-literal:
                    {deromanizer, romanizer} => literal
            """.trimIndent()
        )

        ch5("ideromanizeriromanizeri") shouldBe "iliteraliliterali"

        val ch6 = lsc(
            """
                then-else:
                    then => else
            """.trimIndent()
        )

        ch6("ifthendo") shouldBe "ifelsedo"

        val ch7 = lsc(
            """
                off-unchanged:
                    off => unchanged
            """.trimIndent()
        )

        ch7("coffee") shouldBe "cunchangedee"

        val ch8 = lsc(
            """
                element-defer:
                    element => defer
            """.trimIndent()
        )

        ch8("elementary") shouldBe "deferary"
    }
})