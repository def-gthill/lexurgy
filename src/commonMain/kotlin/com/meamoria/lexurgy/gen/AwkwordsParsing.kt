package com.meamoria.lexurgy.gen

import com.meamoria.lexurgy.BoringErrorListener
import com.meamoria.lexurgy.Interpreter
import com.meamoria.lexurgy.Walker
import com.meamoria.mpp.antlr.*

object AwkwordsInterpreter : Interpreter<ParseNode, AwkwordsParser>(AwkwordsWalker) {

    fun parsePattern(text: String): ParseNode = parseAndWalk(text) { it.pattern() }

    fun parseAlternative(text: String): ParseNode = parseAndWalk(text) { it.alternative() }

    fun parseOptional(text: String): ParseNode = parseAndWalk(text) { it.optional() }

    fun parseSequence(text: String): ParseNode = parseAndWalk(text) { it.sequence() }

    fun parseSubreference(text: String): ParseNode = parseAndWalk(text) { it.subref() }

    override fun lexerFor(inputStream: CharStream): Lexer = AwkwordsLexer(inputStream)

    override fun parserFor(tokenStream: TokenStream): AwkwordsParser =
        AwkwordsParser(tokenStream).apply {
            removeErrorListeners()
            addErrorListener(AwkwordsErrorListener())
        }
}

object AwkwordsWalker : AwkwordsBaseVisitor<ParseNode>(), Walker<ParseNode> {
    override fun visitAlternative(ctx: AwkwordsParser.AlternativeContext): ParseNode =
        walkAlternative(listVisit(ctx.weightedchoice()))

    override fun visitOptional(ctx: AwkwordsParser.OptionalContext): ParseNode = walkOptional(visit(ctx.pattern()))

    override fun visitSequence(ctx: AwkwordsParser.SequenceContext): ParseNode = walkSequence(listVisit(ctx.children))

    override fun visitSubref(ctx: AwkwordsParser.SubrefContext): ParseNode = walkSubref(ctx.SUBREF().text)

    override fun visitAtom(ctx: AwkwordsParser.AtomContext): ParseNode = walkAtom(ctx.getChild(0).text)

    private fun walkAlternative(elements: List<ParseNode>): ParseNode =
        AlternativeNode(elements.map { it as GeneratorNode })

    private fun walkOptional(element: ParseNode): ParseNode =
        OptionalNode(element as GeneratorNode, 0.5)

    private fun walkSequence(elements: List<ParseNode>): ParseNode =
        SequenceNode(elements.map { it as GeneratorNode })

    private fun walkSubref(name: String): ParseNode =
        ReferenceNode("subref", "sr", name)

    private fun walkAtom(text: String): ParseNode = ConstantNode(text)
}

private class AwkwordsErrorListener : BoringErrorListener() {
    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        e: RecognitionException?
    ): Nothing {
        throw AwkwordsNotParsable(line, charPositionInLine, offendingSymbol.toString(), msg)
    }
}

class AwkwordsNotParsable(val line: Int, val column: Int, val offendingSymbol: String, message: String) :
    Exception("$message (Line $line, column $column")
