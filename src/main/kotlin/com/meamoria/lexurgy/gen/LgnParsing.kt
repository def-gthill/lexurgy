package com.meamoria.lexurgy.gen

import com.meamoria.lexurgy.BoringErrorListener
import com.meamoria.lexurgy.Interpreter
import com.meamoria.lexurgy.Walker
import org.antlr.v4.runtime.*

object LgnInterpreter : Interpreter<ParseNode, LgnParser>(LgnWalker) {

    fun parseClassDeclaration(text: String): ParseNode = parseAndWalk(text) { it.classdecl() }

    fun parsePattern(text: String): ParseNode = parseAndWalk(text) { it.pattern() }

    fun parseSequence(text: String): ParseNode = parseAndWalk(text) { it.sequence() }

    fun parseOptional(text: String): ParseNode = parseAndWalk(text) { it.optional() }

    fun parseList(text: String): ParseNode = parseAndWalk(text) { it.list() }

    override fun lexerFor(inputStream: CharStream): Lexer = LgnLexer(inputStream)

    override fun parserFor(tokenStream: TokenStream): LgnParser =
        LgnParser(tokenStream).apply {
            removeErrorListeners()
            addErrorListener(LgnErrorListener())
        }
}

object LgnWalker : LgnBaseVisitor<ParseNode>(), Walker<ParseNode> {
    override fun visitClassdecl(ctx: LgnParser.ClassdeclContext): ParseNode =
        walkClassDeclaration(
            visit(ctx.name()),
            listVisit(ctx.classelement())
        )

    override fun visitClasselement(ctx: LgnParser.ClasselementContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitPattern(ctx: LgnParser.PatternContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitSequence(ctx: LgnParser.SequenceContext): ParseNode =
        walkSequence(listVisit(ctx.sequenceelement()))

    override fun visitSequenceelement(ctx: LgnParser.SequenceelementContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitList(ctx: LgnParser.ListContext): ParseNode =
        walkList(listVisit(ctx.pattern()))

    override fun visitOptional(ctx: LgnParser.OptionalContext): ParseNode =
        walkOptional(visit(ctx.getChild(0)))

    override fun visitSimple(ctx: LgnParser.SimpleContext): ParseNode =
        visit(ctx.getChild(0))

    override fun visitClassref(ctx: LgnParser.ClassrefContext): ParseNode =
        walkClassReference(visit(ctx.name()))

    override fun visitName(ctx: LgnParser.NameContext): ParseNode =
        walkName(ctx.text)

    override fun visitText(ctx: LgnParser.TextContext): ParseNode =
        walkText(ctx.text)

    private fun walkClassDeclaration(className: ParseNode, elements: List<ParseNode>): ParseNode =
        ClassDeclNode(className.text, elements.map { it as GeneratorNode })

    private class ClassDeclNode(val className: String, val elements: List<GeneratorNode>) : ToStringIsText(), GeneratorNode {
        override val text: String = "cdec($className: ${elements.joinToString()})"

        override fun generator(declarations: Declarations): Generator =
            alternativesGenerator(elements.map { Alternative(it.generator(declarations), 1.0 / elements.size) })
    }

    private fun walkClassReference(className: ParseNode): ParseNode =
        ReferenceNode("class", "ref", className.text)

    private fun walkSequence(items: List<ParseNode>): ParseNode =
        SequenceNode(items.map { it as GeneratorNode })

    private fun walkOptional(item: ParseNode): ParseNode =
        OptionalNode(item as GeneratorNode, 0.5)

    private fun walkList(items: List<ParseNode>): ParseNode =
        AlternativeNode(items.map { it as GeneratorNode })

    private fun walkText(text: String): ParseNode = ConstantNode(text)

    private fun walkName(text: String): ParseNode = TextNode(text)
}

private class LgnErrorListener : BoringErrorListener() {
    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String,
        e: RecognitionException?
    ): Nothing {
        throw LgnNotParsable(line, charPositionInLine, offendingSymbol.toString(), msg)
    }
}

class LgnNotParsable(val line: Int, val column: Int, val offendingSymbol: String, message: String) :
    Exception("$message (Line $line, column $column")
