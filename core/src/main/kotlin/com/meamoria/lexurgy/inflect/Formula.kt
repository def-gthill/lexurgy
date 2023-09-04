package com.meamoria.lexurgy.inflect

import com.meamoria.lexurgy.word.Word

sealed interface Formula {
    fun inflect(stem: Word): Word
}

object Stem : Formula {
    override fun inflect(stem: Word): Word = stem
}

class Fixed(val form: Word) : Formula {
    constructor(form: String) : this(Word(form))

    override fun inflect(stem: Word): Word = form
}

class Concat(val parts: List<Formula>) : Formula {
    constructor(vararg parts: Formula) : this(parts.asList())

    override fun inflect(stem: Word): Word =
        Word.join(parts.map { it.inflect(stem) })
}
