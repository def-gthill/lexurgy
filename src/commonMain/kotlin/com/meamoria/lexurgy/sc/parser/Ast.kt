package com.meamoria.lexurgy.sc.parser

import com.meamoria.lexurgy.sc.Matrix
import com.meamoria.lexurgy.sc.MatrixValue
import com.meamoria.lexurgy.sc.RepeaterType
import com.meamoria.lexurgy.sc.SimpleValue

interface AstNode {
    /**
     * The original text that was parsed to produce this node
     */
    val text: String
}

abstract class BaseAstNode(override val text: String) : AstNode {
    override fun toString(): String = text
}

internal class RepeaterTypeNode(
    text: String,
    val type: RepeaterType,
) : BaseAstNode(text)

internal class MatrixNode(
    text: String,
    val matrix: Matrix,
) : BaseAstNode(text)

internal open class MatrixValueNode(
    text: String,
    val value: MatrixValue,
) : BaseAstNode(text)

internal class SimpleValueNode(
    text: String,
    val simpleValue: SimpleValue,
) : MatrixValueNode(text, simpleValue)

internal class TextNode(
    text: String,
    val literalText: String,
    val isExact: Boolean
) : BaseAstNode(text)

internal class NameNode(
    text: String,
    val name: String,
) : BaseAstNode(text)
