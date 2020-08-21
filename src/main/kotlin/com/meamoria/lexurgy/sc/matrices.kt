package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.LscUserError

class Matrix(val valueList: List<MatrixValue>) {
    private val valueSet = valueList.toSet()

    fun bindVariables(bindings: Bindings): Matrix {
        var updated = false
        val values = valueList.toMutableList()
        for ((feature, value) in bindings.features) {
            val index = values.indexOfFirst { it is FeatureVariable && it.featureName == feature.name }
            if (index >= 0) {
                values.removeAt(index)
                values.add(value)
                updated = true
            }
        }
        return if (updated) Matrix(values) else this
    }

    override fun toString(): String = valueList.joinToString(separator = " ", prefix = "[", postfix = "]")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Matrix
        return valueSet == other.valueSet
    }

    override fun hashCode(): Int {
        return valueSet.hashCode()
    }
}

interface MatrixValue {
    fun matches(declarations: Declarations, matrix: Matrix, bindings: Bindings): Boolean
}

data class NegatedValue(val value: String) : MatrixValue {
    override fun matches(declarations: Declarations, matrix: Matrix, bindings: Bindings): Boolean =
        with (declarations) {
            value.toSimpleValue() !in matrix.simpleValues
        }
}

data class FeatureVariable(val featureName: String) : MatrixValue {
    override fun matches(declarations: Declarations, matrix: Matrix, bindings: Bindings): Boolean {
        with(declarations) {
            // Don't try to bind the default values from an empty matrix
            if (matrix.valueList.isEmpty()) return false
            val featureObject = featureName.toFeature()
            val match = featureObject.allValues.filter { it in matrix.fullValueSet }
            return match.firstOrNull()?.let {
                bindings.features[featureObject] = it
            } != null
        }
    }

    override fun toString(): String = "$$featureName"
}

data class SimpleValue(val name: String) : MatrixValue {
    override fun matches(declarations: Declarations, matrix: Matrix, bindings: Bindings): Boolean =
        with (declarations) {
            name.toSimpleValue() in matrix.simpleValues
        }

    override fun toString(): String = name

    companion object {
        fun absent(featureName: String): SimpleValue = SimpleValue("*$featureName")
    }
}

class LscInvalidMatrix(val matrix: Matrix) :
    LscUserError("No combination of a symbol and diacritics has the matrix $matrix")
