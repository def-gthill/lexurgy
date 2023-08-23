package com.meamoria.lexurgy.inflect

import com.meamoria.lexurgy.word.Word

sealed interface CategoryTree {
    fun inflect(stem: Word, categories: Set<String> = emptySet()): Word

    fun inflectAll(
        vararg stemAndCategories: StemAndCategories
    ): List<Word> = stemAndCategories.map {
        (stem, categories) -> inflect(stem, categories)
    }
}

class Form(val form: Word) : CategoryTree {
    constructor(form: String) : this(Word(form))

    override fun inflect(stem: Word, categories: Set<String>): Word {
        return form
    }
}

class CategorySplit(
    vararg val branches: Pair<String, CategoryTree>
) : CategoryTree {

    constructor(branches: Map<String, CategoryTree>) : this(
        *branches.entries.map { it.key to it.value }.toTypedArray()
    )

    override fun inflect(stem: Word, categories: Set<String>): Word {
        return branches
            .firstOrNull {it.first in categories }
            ?.second
            ?.inflect(stem, categories)
            ?: throw UnspecifiedCategory(
                stem, categories, branches.map { it.first }.toSet()
            )
    }
}

typealias StemAndCategories = Pair<Word, Set<String>>
