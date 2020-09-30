package com.meamoria.lexurgy.gen

import com.meamoria.lexurgy.BoringErrorListener
import com.meamoria.lexurgy.Interpreter
import com.meamoria.lexurgy.Walker
import org.antlr.v4.runtime.*

class LgnInterpreter<T>(val walker: LgnWalker<T>) : Interpreter<T, LgnParser>(walker) {

    fun parseClassDeclaration(text: String): T = parseAndWalk(text) { it.classdecl() }

    fun parsePattern(text: String): T = parseAndWalk(text) { it.pattern() }

    fun parseSequence(text: String): T = parseAndWalk(text) { it.sequence() }

    fun parseOptional(text: String): T = parseAndWalk(text) { it.optional() }

    override fun lexerFor(inputStream: CharStream): Lexer = LgnLexer(inputStream)

    override fun parserFor(tokenStream: TokenStream): LgnParser =
        LgnParser(tokenStream).apply {
            removeErrorListeners()
            addErrorListener(LgnErrorListener())
        }
}

abstract class LgnWalker<T> : LgnBaseVisitor<T>(), Walker<T> {
    override fun visitClassdecl(ctx: LgnParser.ClassdeclContext): T = walkClassDeclaration(
        visit(ctx.name()),
        listVisit(ctx.classelement())
    )

    override fun visitClasselement(ctx: LgnParser.ClasselementContext): T = visit(ctx.getChild(0))

    override fun visitPattern(ctx: LgnParser.PatternContext): T = visit(ctx.getChild(0))

    override fun visitSequence(ctx: LgnParser.SequenceContext): T =
        walkSequence(listVisit(ctx.sequenceelement()))

    override fun visitSequenceelement(ctx: LgnParser.SequenceelementContext): T = visit(ctx.getChild(0))

    override fun visitClassref(ctx: LgnParser.ClassrefContext): T = walkClassReference(visit(ctx.name()))

    override fun visitName(ctx: LgnParser.NameContext): T = walkText(ctx.text)

    override fun visitText(ctx: LgnParser.TextContext): T = walkText(ctx.text)

    protected abstract fun walkClassDeclaration(className: T, elements: List<T>): T

    protected abstract fun walkClassReference(className: T): T

    protected abstract fun walkSequence(items: List<T>): T

    protected abstract fun walkText(text: String): T
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