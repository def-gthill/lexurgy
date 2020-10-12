package com.meamoria.lexurgy.gen

import com.meamoria.lexurgy.BoringErrorListener
import com.meamoria.lexurgy.Interpreter
import com.meamoria.lexurgy.Walker
import org.antlr.v4.runtime.*

object LgnInterpreter : Interpreter<GeneratorNode, LgnParser>(LgnWalker) {

    fun parseClassDeclaration(text: String): GeneratorNode = parseAndWalk(text) { it.classdecl() }

    fun parsePattern(text: String): GeneratorNode = parseAndWalk(text) { it.pattern() }

    fun parseSequence(text: String): GeneratorNode = parseAndWalk(text) { it.sequence() }

    fun parseOptional(text: String): GeneratorNode = parseAndWalk(text) { it.optional() }

    fun parseList(text: String): GeneratorNode = parseAndWalk(text) { it.list() }

    override fun lexerFor(inputStream: CharStream): Lexer = LgnLexer(inputStream)

    override fun parserFor(tokenStream: TokenStream): LgnParser =
        LgnParser(tokenStream).apply {
            removeErrorListeners()
            addErrorListener(LgnErrorListener())
        }
}

object LgnWalker : LgnBaseVisitor<GeneratorNode>(), Walker<GeneratorNode> {
    override fun visitClassdecl(ctx: LgnParser.ClassdeclContext): GeneratorNode =
        walkClassDeclaration(
            visit(ctx.name()),
            listVisit(ctx.classelement())
        )

    override fun visitClasselement(ctx: LgnParser.ClasselementContext): GeneratorNode =
        visit(ctx.getChild(0))

    override fun visitPattern(ctx: LgnParser.PatternContext): GeneratorNode =
        visit(ctx.getChild(0))

    override fun visitSequence(ctx: LgnParser.SequenceContext): GeneratorNode =
        walkSequence(listVisit(ctx.sequenceelement()))

    override fun visitSequenceelement(ctx: LgnParser.SequenceelementContext): GeneratorNode =
        visit(ctx.getChild(0))

    override fun visitList(ctx: LgnParser.ListContext): GeneratorNode =
        walkList(listVisit(ctx.pattern()))

    override fun visitOptional(ctx: LgnParser.OptionalContext): GeneratorNode =
        walkOptional(visit(ctx.getChild(0)))

    override fun visitSimple(ctx: LgnParser.SimpleContext): GeneratorNode =
        visit(ctx.getChild(0))

    override fun visitClassref(ctx: LgnParser.ClassrefContext): GeneratorNode =
        walkClassReference(visit(ctx.name()))

    override fun visitName(ctx: LgnParser.NameContext): GeneratorNode =
        walkText(ctx.text)

    override fun visitText(ctx: LgnParser.TextContext): GeneratorNode =
        walkText(ctx.text)

    private fun walkClassDeclaration(className: GeneratorNode, elements: List<GeneratorNode>): GeneratorNode =
        TODO()

    private fun walkClassReference(className: GeneratorNode): GeneratorNode =
        TODO()

    private fun walkSequence(items: List<GeneratorNode>): GeneratorNode =
        TODO()

    private fun walkOptional(item: GeneratorNode): GeneratorNode =
        TODO()

    private fun walkList(items: List<GeneratorNode>): GeneratorNode =
        TODO()

    private fun walkText(text: String): GeneratorNode =
        TODO()
}

interface GeneratorNode {
    /**
     * Retrieves the generator represented by this parse tree node
     */
    fun generator(): Generator

    // Then override toString() to get the string representations we
    // use when testing the parser.
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

class LgnUndefinedName(val nameType: String, val undefinedName: String) :
    Exception("The $nameType name $undefinedName is not defined")