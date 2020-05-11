package com.meamoria.lexurgy.sc

class Matrix(val valueList: List<MatrixValue>) {
    val valueSet: Set<MatrixValue> = valueList.toSet()
    val simpleValues: Set<SimpleValue> = valueSet.filterIsInstanceTo(mutableSetOf())
    val simpleValueStrings: Set<String> = simpleValues.mapTo(mutableSetOf()) { it.name }

    fun bindVariables(bindings: Bindings): Matrix = this //TODO
}

interface MatrixValue {
    fun matches(declarations: Declarations, matrix: Matrix, bindings: Bindings): Boolean
}

class SimpleValue(val name: String): MatrixValue {
    override fun matches(declarations: Declarations, matrix: Matrix, bindings: Bindings): Boolean =
        name in matrix.simpleValueStrings
}