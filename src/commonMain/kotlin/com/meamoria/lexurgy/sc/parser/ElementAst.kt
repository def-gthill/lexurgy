package com.meamoria.lexurgy.sc.parser

import com.meamoria.lexurgy.sc.LscWalker
import com.meamoria.lexurgy.sc.Matcher


internal interface Element : AstNode {
    val publicName: String

    fun matcher(context: LscWalker.ElementContext, declarations: LscWalker.ParseDeclarations): Matcher

    val subElements: List<Element>
        get() = emptyList()
}
