package com.meamoria.lexurgy.sc

class Matrix(val valueList: List<MatrixValue>) {
    val valueSet: Set<MatrixValue> = valueList.toSet()
    val simpleValues: Set<SimpleValue> = valueSet.filterIsInstanceTo(mutableSetOf())
    val simpleValueStrings: Set<String> = simpleValues.mapTo(mutableSetOf()) { it.name }

    fun bindVariables(bindings: Bindings): Matrix = this //TODO

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

data class SimpleValue(val name: String): MatrixValue {
    override fun matches(declarations: Declarations, matrix: Matrix, bindings: Bindings): Boolean =
        name in matrix.simpleValueStrings

    override fun toString(): String = name
}

class LscInvalidMatrix(val matrix: Matrix) :
    Exception("No combination of a symbol and diacritics has the matrix $matrix")