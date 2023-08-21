package com.meamoria.lexurgy.sc.parser

import com.meamoria.lexurgy.sc.Declarations
import com.meamoria.lexurgy.sc.LscUndefinedName
import com.meamoria.lexurgy.sc.LscWalker

internal class ParseTimeDeclarations(
    val elements: Map<String, Element>,
    val blocks: Map<String, LscWalker.UnlinkedStandardRule>,
    val runtime: Declarations,
) {
    fun dereferenceElement(name: String): Element =
        elements[name] ?: throw LscUndefinedName("element", name)

    fun dereferenceBlock(name: String): LscWalker.UnlinkedStandardRule =
        blocks[name] ?: throw LscUndefinedName("block", name)

    companion object {
        val empty: ParseTimeDeclarations =
            ParseTimeDeclarations(emptyMap(), emptyMap(), Declarations.empty)
    }
}
