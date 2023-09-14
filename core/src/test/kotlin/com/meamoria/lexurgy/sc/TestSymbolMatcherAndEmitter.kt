package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.sc.element.SymbolEmitter
import com.meamoria.lexurgy.sc.element.SymbolMatcher
import com.meamoria.lexurgy.word.*
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.beEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

@Suppress("unused")
class TestSymbolMatcherAndEmitter : FreeSpec({
    fun word(schematic: String): Word = StandardWord.fromSchematic(schematic)

    fun phrase(vararg schematic: String): Phrase = Phrase(schematic.map(::word))

    fun floatingDiacriticAfter(symbol: String, feature: String) =
        Diacritic(
            symbol,
            Matrix(listOf(SimpleValue(feature))),
            ModifierPosition.AFTER,
            floating = true,
        )

    fun diacriticBefore(symbol: String, feature: String) =
        Diacritic(
            symbol,
            Matrix(listOf(SimpleValue(feature))),
            ModifierPosition.BEFORE,
            floating = false,
        )

    fun testSymbolEmitterFromSymbolMatcher(
        declarations: Declarations,
        matcherText: String,
        emitterText: String,
        inputPhrase: String,
        expectedOutputPhrase: String,
        expectedSyllableFeatureChanges: Map<PhraseIndex, Matrix> = emptyMap()
    ) {
        val emitter = SymbolEmitter(declarations, word(emitterText))
        val matcher = SymbolMatcher(declarations, word(matcherText))
        val result = emitter.result(matcher, phrase(inputPhrase)).bind(Bindings())
        val expectedPhrase = phrase(expectedOutputPhrase)
        result.phrase.toSyllabified() shouldBe expectedPhrase.toSyllabified()
        result.emitsSyllableBreaks should beEmpty()
        result.syllableFeatureChanges.filterValues {
            it != Matrix.EMPTY
        } shouldBe expectedSyllableFeatureChanges
    }

    "A symbol matcher" - {
        "with one simple segment" - {
            "matches a segment with a syllable feature" {
                val declarations = Declarations.create(
                    listOf(Feature.plusOnly("stress", WordLevel.SYLLABLE)),
                    listOf(diacriticBefore("'", "+stress")),
                    emptyList(),
                )
                val matcher = SymbolMatcher(declarations, word("i"))
                val claims = matcher.claim(
                    phrase("'((i"),
                    PhraseIndex(0, 0),
                    Bindings()
                )
                claims shouldHaveSize 1
                val claim = claims.single()
                claim.index shouldBe PhraseIndex(0, 1)
            }
        }

        "with a syllable-level diacritic" - {
            "doesn't match a segment without that feature on its syllable" {
                val declarations = Declarations.create(
                    listOf(Feature.plusOnly("stress", WordLevel.SYLLABLE)),
                    listOf(diacriticBefore("'", "+stress")),
                    emptyList(),
                )
                val matcher = SymbolMatcher(declarations, word("'((i"))
                matcher.claim(
                    phrase("i"),
                    PhraseIndex(0, 0),
                    Bindings()
                ) should beEmpty()
            }
        }
    }

    "A symbol emitter" - {
        "with one simple segment" - {
            "transforming a symbol matcher" - {
                "with one simple segment" - {
                    "returns its text" {
                        testSymbolEmitterFromSymbolMatcher(
                            declarations = Declarations.empty,
                            matcherText = "i",
                            emitterText = "a",
                            inputPhrase = "i",
                            expectedOutputPhrase = "a",
                        )
                    }

                    "copies floating diacritics from the input" {
                        val declarations = Declarations.create(
                            listOf(Feature.plusOnly("hightone")),
                            listOf(floatingDiacriticAfter("'", "+hightone")),
                            emptyList(),
                        )
                        testSymbolEmitterFromSymbolMatcher(
                            declarations = declarations,
                            matcherText = "i",
                            emitterText = "a",
                            inputPhrase = "i)'",
                            expectedOutputPhrase = "a)'",
                        )
                    }

                    "copies syllable-level diacritics from the input" {
                        val declarations = Declarations.create(
                            listOf(Feature.plusOnly("stress", WordLevel.SYLLABLE)),
                            listOf(diacriticBefore("'", "+stress")),
                            emptyList(),
                        )
                        testSymbolEmitterFromSymbolMatcher(
                            declarations = declarations,
                            matcherText = "i",
                            emitterText = "a",
                            inputPhrase = "'((i",
                            expectedOutputPhrase = "'((a"
                        )
                    }
                }

                "with a floating diacritic" - {
                    "strips off the floating diacritic in the input" {
                        val declarations = Declarations.create(
                            listOf(Feature.plusOnly("hightone")),
                            listOf(floatingDiacriticAfter("'", "+hightone")),
                            emptyList(),
                        )
                        testSymbolEmitterFromSymbolMatcher(
                            declarations = declarations,
                            matcherText = "i)'",
                            emitterText = "a",
                            inputPhrase = "i)'",
                            expectedOutputPhrase = "a",
                        )
                    }
                }

                "with a syllable-level diacritic" - {
                    "demands removal of the syllable-level feature in the input" {
                        val declarations = Declarations.create(
                            listOf(Feature.plusOnly("stress", WordLevel.SYLLABLE)),
                            listOf(diacriticBefore("'", "+stress")),
                            emptyList(),
                        )
                        testSymbolEmitterFromSymbolMatcher(
                            declarations = declarations,
                            matcherText = "'((i",
                            emitterText = "a",
                            inputPhrase = "'((i",
                            expectedOutputPhrase = "a",
                            expectedSyllableFeatureChanges = mapOf(
                                PhraseIndex(0, 0) to
                                        Matrix(listOf(SimpleValue("-stress")))
                            ),
                        )
                    }
                }
            }
        }
    }
})
