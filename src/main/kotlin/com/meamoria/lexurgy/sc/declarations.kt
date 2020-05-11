package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.PhoneticSegment
import com.meamoria.lexurgy.PhoneticWord
import com.meamoria.lexurgy.PlainSegment
import com.meamoria.lexurgy.Word

class Declarations(
    features: List<Feature>,
    diacritics: List<Diacritic>,
    symbols: List<Symbol>,
    classes: List<SegmentClass>
) {
    private val symbolSegmentToSymbol = symbols.associateBy { it.name }

    fun parsePhonetic(text: String): Word<PhoneticSegment> =
        PhoneticWord(text.chunked(1))
//         phoneticParser.parse(text)

    fun parsePhonetic(word: Word<PlainS>): Word<PhonS> = parsePhonetic(word.string)

    /**
     * Tries to match the specified matrix to the specified phonetic symbol.
     * Returns true if the matrix matched, false otherwise. Binds variables.
     */
    fun symbolMatches(symbol: PhoneticSegment, matrix: Matrix, bindings: Bindings): Boolean {
        val complexSymbolMatrix = symbolToMatrix(symbol) ?: return false
        for (value in matrix.valueList) {
            if (!value.matches(this, complexSymbolMatrix, bindings)) return false
        }
        return true
    }

    fun symbolToMatrix(symbol: PhoneticSegment): Matrix? {
        val coreSymbol = symbolSegmentToSymbol[symbol.string] ?: return null
        val complexSymbol = ComplexSymbol(coreSymbol)
        return complexSymbolToMatrix(complexSymbol)
    }

    private fun complexSymbolToMatrix(symbol: ComplexSymbol): Matrix {
        return symbol.symbol.matrix
    }

    fun matrixToSymbol(matrix: Matrix): PhoneticSegment {
        TODO()
    }

    fun updateMatrix(oldMatrix: Matrix, updateMatrix: Matrix): Matrix {
        TODO()
    }
}

class SegmentClass

class Feature(val name: String, val values: List<SimpleValue>, val nullAlias: SimpleValue? = null)

class Symbol(val name: String, val matrix: Matrix)

class ComplexSymbol(val symbol: Symbol, diacritics: List<Diacritic> = emptyList())

class Diacritic
