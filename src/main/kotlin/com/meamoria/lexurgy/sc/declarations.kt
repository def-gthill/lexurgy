package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*

class Declarations(
    val features: List<Feature>,
    val diacritics: List<Diacritic>,
    val symbols: List<Symbol>,
    val classes: List<SegmentClass>
) {

    private val featureNameToFeatureMap = features.associateBy { it.name }
    private val valueToFeature = features.flatMap { feature ->
        feature.allValues.map { it to feature }
    }.toMap()
    private val nulls = features.mapNotNull { it.nullAlias }

    private val diacriticNameToDiacritic = diacritics.associateBy { it.name }

    private val symbolsAsComplexSymbols = symbols.map { ComplexSymbol(it) }
    private val symbolNameToSymbol = symbols.associateBy { it.name }
    private val matrixToSimpleSymbol = symbols.associateBy { it.matrix }

    private val matrixToSymbolCache = mutableMapOf<Matrix, PhoneticSegment>()

    private val phoneticParser = PhoneticParser(
        symbols.map { it.name },
        diacritics.filter { it.before }.map { it.name },
        diacritics.filterNot { it.before }.map { it.name }
    )

    fun parsePhonetic(text: String): Word<PhoneticSegment> =
        phoneticParser.parse(text)

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
            val realValue = if (value.isNull())
                AbsentFeature(valueToFeature.getValue(value as SimpleValue).name)
            else value
            if (!realValue.matches(this, complexSymbolMatrix, bindings)) return false
        }
        return true
    }

    private fun MatrixValue.isNull(): Boolean = this in nulls

    fun symbolToMatrix(symbol: PhoneticSegment): Matrix? {
        val (core, before, after) = phoneticParser.breakDiacritics(symbol.string)
        val coreSymbol = symbolNameToSymbol[core] ?: return null
        val diacritics = (before + after).map { diacriticNameToDiacritic.getValue(it) }
        val complexSymbol = ComplexSymbol(coreSymbol, diacritics)
        return complexSymbolToMatrix(complexSymbol)
    }

    private fun complexSymbolToMatrix(symbol: ComplexSymbol): Matrix {
        var result = symbol.symbol.matrix
        for (diacritic in symbol.diacritics) result = result.update(diacritic.matrix)
        return result
    }

    fun matrixToSymbol(matrix: Matrix): PhoneticSegment {
        matrixToSymbolCache[matrix]?.let { return it }

        val realMatrix = matrix.removeExplicitNulls()

        val result = matrixToSimpleSymbol[realMatrix]?.let {
            PhoneticSegment(it.name)
        } ?: searchDiacritics(realMatrix)?.let {
            PhoneticSegment(it.string)
        } ?: throw LscInvalidMatrix(realMatrix)

        return result.also { matrixToSymbolCache[matrix] = it }
    }

    private fun Matrix.removeExplicitNulls(): Matrix = Matrix(valueList.filterNot { it.isNull() })

    private fun searchDiacritics(
        matrix: Matrix,
        candidates: List<ComplexSymbol> = symbolsAsComplexSymbols,
        bestDistance: Int? = null
    ): ComplexSymbol? {
        val sortedCandidates = candidates.sortedBy { symbolToMatrixDistance(it, matrix) }
        sortedCandidates.first().takeIf { symbolToMatrixDistance(it, matrix) == 0 }?.let { return it }

        for (candidate in sortedCandidates) {
            val candidateDistance = symbolToMatrixDistance(candidate, matrix)
            if (bestDistance != null && candidateDistance >= bestDistance) return null
            val withDiacritics = diacritics.map(candidate::withDiacritic)
            searchDiacritics(matrix, withDiacritics, candidateDistance)?.let { return it }
        }
        return null
    }

    private fun symbolToMatrixDistance(symbol: ComplexSymbol, matrix: Matrix): Int {
        val symbolMatrix = complexSymbolToMatrix(symbol)
        val difference = (matrix.simpleValues.filterNot { it in symbolMatrix.simpleValues } +
                symbolMatrix.simpleValues.filterNot { it in matrix.simpleValues }
                )
        return difference.size
    }

    fun Matrix.update(updateMatrix: Matrix): Matrix {
        val oldMatrixFeatures = simpleValues.associateBy { valueToFeatureOrThrow(it) }
        val newMatrixValues = valueList.toMutableList()
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

class ComplexSymbol(val symbol: Symbol, val diacritics: List<Diacritic> = emptyList()) {
    val string = (diacritics.filter { it.before }.map { it.name } +
            listOf(symbol.name) +
            diacritics.filterNot { it.before }.map { it.name }
            ).joinToString("")

    fun withDiacritic(diacritic: Diacritic): ComplexSymbol =
        ComplexSymbol(symbol, diacritics + diacritic)

    override fun toString(): String = string
}

data class Diacritic(val name: String, val matrix: Matrix, val before: Boolean)

class LscUndefinedName(val nameType: String, val undefinedName: String) :
    Exception("The $nameType name $undefinedName is not defined")
