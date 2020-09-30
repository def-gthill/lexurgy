package com.meamoria.lexurgy.gen

import com.meamoria.lexurgy.BoringErrorListener
import com.meamoria.lexurgy.Interpreter
import com.meamoria.lexurgy.Walker
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.ParseTree

class AwkwordsInterpreter<T>(val walker: AwkwordsWalker<T>) : Interpreter<T, AwkwordsParser>(walker) {

    fun parsePattern(text: String): T = parseAndWalk(text) { it.pattern() }

    fun parseAlternative(text: String): T = parseAndWalk(text) { it.alternative() }

    fun parseOptional(text: String): T = parseAndWalk(text) { it.optional() }

    fun parseSequence(text: String): T = parseAndWalk(text) { it.sequence() }

    fun parseSubreference(text: String): T = parseAndWalk(text) { it.subref() }

    override fun lexerFor(inputStream: CharStream): Lexer = AwkwordsLexer(inputStream)

    override fun parserFor(tokenStream: TokenStream): AwkwordsParser =
        AwkwordsParser(tokenStream).apply {
            removeErrorListeners()
            addErrorListener(AwkwordsErrorListener())
        }
}

abstract class AwkwordsWalker<T> : AwkwordsBaseVisitor<T>(), Walker<T> {
    override fun visitAlternative(ctx: AwkwordsParser.AlternativeContext): T =
        walkAlternative(listVisit(ctx.weightedchoice()))

    override fun visitOptional(ctx: AwkwordsParser.OptionalContext): T = walkOptional(visit(ctx.pattern()))

    override fun visitSequence(ctx: AwkwordsParser.SequenceContext): T = walkSequence(listVisit(ctx.children))

    override fun visitSubref(ctx: AwkwordsParser.SubrefContext): T = walkSubref(ctx.SUBREF().text)

    override fun visitAtom(ctx: AwkwordsParser.AtomContext): T = walkAtom(ctx.getChild(0).text)

    abstract fun walkAlternative(elements: List<T>): T

    abstract fun walkOptional(element: T): T

    abstract fun walkSequence(elements: List<T>): T

    abstract fun walkSubref(name: String): T

    abstract fun walkAtom(text: String): T
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

class AwkwordsUndefinedName(val nameType: String, val undefinedName: String) :
    Exception("The $nameType name $undefinedName is not defined")
