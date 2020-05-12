package com.meamoria.lexurgy.sc

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

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

    "We should be able to match sounds against a simple feature matrix" {
        val ch = lsc(
            """
               |Feature Manner(stop, nonstop)
               |Symbol p [stop]
               |Symbol t [stop]
               |Symbol k [stop]
               |Symbol f [nonstop]
               |drop-stop:
               |    [stop] => *
            """.trimMargin()
        )

        ch("klaptrap") shouldBe "lara"
        ch("fniftikuf") shouldBe "fnifiuf"
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

    "We should be able to rename the \"absent\" value of a feature" {
        val ch = lsc(
            """
               |Feature Place(lab, apic)
               |Feature Breath(*plain, aspir)
               |Diacritic ʰ [aspir]
               |Symbol p [lab]
               |Symbol t [apic]
               |aspiration:
               |    [plain] s => [aspir] *
               |lenition:
               |    [aspir] => [plain] / a _ a
               |    [plain] => * / a _ a
            """.trimMargin()
        )

        ch("psataba") shouldBe "pʰaaba"
        ch("patsaba") shouldBe "pataba"
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
})