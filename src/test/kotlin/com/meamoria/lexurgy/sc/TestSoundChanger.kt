package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.loadList
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.beOfType
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import java.nio.file.Paths

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
        shouldThrow<LscNotParsable> { lsc(
            """
                a-rule:
                x=>h
                ]]]]]
            """.trimIndent()
        ) }
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
            """.trimIndent()
        )

        ch("tˈewtáj") shouldBe "tˈuwtéj"
        ch("tˈájtaj") shouldBe "tˈu̘jtej"
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
                [${'$'}Height ${'$'}Depth] => * / [${'$'}Height ${'$'}Depth] _
            """.trimIndent()
        )

        ch1("anni") shouldBe "anne"
        ch1("inna") shouldBe "inno"
        ch1("beetaamae") shouldBe "betamae"

        val ch2 = lsc(
            """
                Feature Height(low, high)
                Feature Depth(front, back)
                Feature Rounding(round, unround)
                Symbol a [low back unround]
                Symbol o [low back round]
                Symbol e [low front unround]
                Symbol ö [low front round]
                Symbol ï [high back unround]
                Symbol u [high back round]
                Symbol i [high front unround]
                Symbol ü [high front round]
                coalescence:
                {[${'$'}Rounding ${'$'}Height] [high ${'$'}Depth], [high ${'$'}Depth] [${'$'}Rounding ${'$'}Height]} => [${'$'}Rounding ${'$'}Depth ${'$'}Height] *
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

        shouldThrow<LscInvalidRuleExpression> { lsc("harmony [vowel]:\n[low] * => [high] a") }
        shouldThrow<LscInvalidRuleExpression> { lsc("harmony [vowel]:\n[low] ai => [high] a") }
        shouldNotThrowAny { lsc("Symbol ai\nharmony [vowel]:\n[low] ai => [high] a") }
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
                harmony-backward [vowel] propagate:
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
        ex.cause should beOfType<LscDivergingPropagation>()
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
                    Then:
                    [long] => [short]
                    Then:
                    ʃ => sh
                    {ˈa, ˈe, ˈu, ˈi} => {á, é, ú, í}
                    
            """.trimIndent()
        )

        ch("shamu") shouldBe "saamú"
        ch("arima") shouldBe "aarimá"
        ch("chamek") shouldBe "shaamék"
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
            null to listOf("säsi", "vänesäk")
        )
    }

    "The Kharulian consonant separation rule should break apart consecutive consonants" {
        // My current position is "don't fix this". Put warnings in the documentation that different environment
        // lengths don't mix well in alternative environments.
        val ch = lsc(
            """
                Class vowel {a, i, ə}
                Class cons {p, t, k, s, m, n, l, r}
                break-up-clusters:
                    * => ə / {$ @cons _ @cons, @cons @cons _ @cons, @vowel @cons _ @cons $}
            """.trimIndent()
        )

        ch("mtmkaasr") shouldBe "mətəməkaasər"
        ch("tmkipnralpt") shouldBe "təməkipnəralpət"
    }

    "The Caidorian syncope rule should work properly (i.e. before environments should match backwards from the anchor" {
        val ch = lsc(
            """
                Feature Type(*cons, vowel)
                Feature Height(low, lowmid, mid, high)
                Feature Depth(front, central, back)
                Feature Stress(*unstressed, stressed)
                Feature Length(*short, long)

                Diacritic ́  (floating) [stressed]
                Diacritic ː (floating) [long]

                Symbol pʰ, tʰ, cʰ, kʰ, bʱ, dʱ, ɟʱ, gʱ
                Symbol ɛ [vowel lowmid front]
                Symbol e [vowel mid front]
                Symbol i [vowel high front]
                Symbol a [vowel low central]
                Symbol ɔ [vowel lowmid back]
                Symbol o [vowel mid back]
                Symbol u [vowel high back]
                
                Class aspir {pʰ, tʰ, cʰ, kʰ}
                Class breathy {bʱ, dʱ, ɟʱ, gʱ}
                Class unvcd {p, t, c, k}
                Class vcd {b, d, ɟ, g}
                Class stop {@aspir, @breathy, @unvcd, @vcd}
                Class fricative {f, s, ç}
                Class obstruent {@stop, @fricative}

                Deromanizer:
                    {ph, th, ch, kh} => {pʰ, tʰ, cʰ, kʰ}
                    {bh, dh, jh, gh} => {bʱ, dʱ, ɟʱ, gʱ}
                    j => ɟ
                    sh => ç
                    nh => ɲ
                    Then:
                    [vowel]${'$'}1 ${'$'}1 => [long] *
                    Then:
                    [vowel] => [stressed] / ${'$'} [cons]* _
                syncope:
                    [vowel short] => * / [vowel stressed] [cons]* _ @stop [cons]* [vowel]
                    [vowel short] => * / [vowel stressed] [cons]* @obstruent _ @obstruent [cons]* [vowel]
            """.trimIndent()
        )

        ch("migomausis") shouldBe "mígomausis"
        ch("egidhi") shouldBe "égdʱi"
        ch("eefase") shouldBe "éːfse"
    }

    "The file format should be fairly robust to extra newlines and blank lines" {
        // We're just testing that these don't throw exceptions
        lsc("Deromanizer:\n    y => j\n")
        lsc("Deromanizer:\n    y => j\nrule:\n    j => ʒ\n\n\n")
        lsc("rule:\n    p => b\n# Pointless comment\n    t => d\n    # Indented pointless comment\n    k => g\n")
    }

    "This sample list of Three Rivers words should evolve into Muipidan words how they did in the old sound changer" {
        val expected = listOf(
            "hullïdo",
            "opayto",
            "ok'oyto",
            "hmallede",
            "hmuhlïdo",
            "hugo",
            "hukhïgo",
            "hube",
            "huphïbe",
            "su",
            "im",
            "osayto",
            "un",
            "kaf",
            "klo",
            "kmuhlue",
            "kaslahn",
            "k'esas"
        )

        val changer = SoundChanger.fromLscFile(Paths.get("test", "muipidan.lsc"))
        val words = loadList(Paths.get("test", "ptr_test.wli"))
        changer.change(words) shouldBe expected
    }
})