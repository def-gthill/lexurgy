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

    private val featureNameToFeatureMap = features.associateBy { it.name }
    private val valueToFeature = features.flatMap { feature ->
        feature.allValues.map { it to feature }
    }.toMap()

    private val symbolSegmentToSymbol = symbols.associateBy { it.name }
    private val matrixToSimpleSymbol = symbols.associateBy { it.matrix }

    private val matrixToSymbolCache = mutableMapOf<Matrix, PhoneticSegment>()

    fun parsePhonetic(text: String): Word<PhoneticSegment> =
        PhoneticWord(text.chunked(1))
//         phoneticParser.parse(text)

    fun parsePhonetic(word: Word<PlainS>): Word<PhonS> = parsePhonetic(word.string)

    fun featureNameToFeature(featureName: String): Feature =
        featureNameToFeatureMap[featureName] ?: throw LscUndefinedName("feature", featureName)

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
        matrixToSymbolCache[matrix]?.let { return it }

        return matrixToSimpleSymbol[matrix]?.let {
            PhoneticSegment(it.name)
        }?.also {
            matrixToSymbolCache[matrix] = it
        } ?: throw LscInvalidMatrix(matrix)
    }

    fun updateMatrix(oldMatrix: Matrix, updateMatrix: Matrix): Matrix {
        val oldMatrixFeatures = oldMatrix.simpleValues.associateBy { valueToFeatureOrThrow(it) }
        val newMatrixValues = oldMatrix.valueList.toMutableList()
        for (value in updateMatrix.valueList) {
            val updateFeature = valueToFeatureOrThrow(value as SimpleValue)
            oldMatrixFeatures[updateFeature]?.let { newMatrixValues.remove(it) }
            newMatrixValues += value
        }
        return Matrix(newMatrixValues)
    }

    private fun valueToFeatureOrThrow(value: SimpleValue): Feature =
        valueToFeature[value] ?: throw LscUndefinedName("feature value", value.name)
}

class SegmentClass

class Feature(val name: String, val values: List<SimpleValue>, val nullAlias: SimpleValue? = null) {
    val allValues: List<SimpleValue> = listOfNotNull(nullAlias) + values

    override fun toString(): String = values.joinToString(prefix = "$name(", postfix = ")")
}

class Symbol(val name: String, val matrix: Matrix) {
    override fun toString(): String = name + if (matrix.valueList.isEmpty()) "" else " $matrix"
}

class ComplexSymbol(val symbol: Symbol, diacritics: List<Diacritic> = emptyList())

class Diacritic

class LscUndefinedName(val nameType: String, val undefinedName: String) :
        Exception("The $nameType name $undefinedName is not defined")
