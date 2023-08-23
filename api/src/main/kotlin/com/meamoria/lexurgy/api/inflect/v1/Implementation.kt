package com.meamoria.lexurgy.api.inflect.v1

import com.meamoria.lexurgy.inflect.CategorySplit
import com.meamoria.lexurgy.inflect.CategoryTree
import com.meamoria.lexurgy.inflect.Form
import com.meamoria.lexurgy.inflect.StemAndCategories
import com.meamoria.lexurgy.word.Word

fun runInflect(request: Request): Response {
    val rules = rulesFromRequest(request.rules)
    val result = rules.inflectAll(
        *stemsAndCategoriesFromRequest(request.stemsAndCategories)
    )
    return SuccessResponse(formsToResponse(result))
}

private fun rulesFromRequest(requestRules: RequestCategoryTree): CategoryTree {
    return when (requestRules) {
        is RequestForm -> Form(requestRules.form)
        is RequestCategorySplit -> CategorySplit(
            requestRules.branches.mapValues {
                rulesFromRequest(it.value)
            }
        )
    }
}

private fun stemsAndCategoriesFromRequest(
    requestStemsAndCategories: List<RequestStemAndCategories>
): Array<StemAndCategories> {
    return requestStemsAndCategories
        .map(::stemAndCategoriesFromRequest)
        .toTypedArray()
}

private fun stemAndCategoriesFromRequest(
    requestStemAndCategories: RequestStemAndCategories
): Pair<Word, Set<String>> {
    val (stem, categories) = requestStemAndCategories
    return Word(stem) to categories.toSet()
}


private fun formsToResponse(forms: List<Word>): List<String> {
    return forms.map { it.string }
}
