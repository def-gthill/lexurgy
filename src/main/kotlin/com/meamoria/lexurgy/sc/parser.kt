package com.meamoria.lexurgy.sc

class LscInterpreter(walker: LscWalker) {
    fun parseValue(text: String): Any = TODO()
}

open class LscWalker

class LscNotParsable(val line: Int, val column: Int, val offendingSymbol: String, message: String) :
    Exception("$message (Line $line, column $column")
