package com.meamoria.lexurgy.api.inflect.v1

import com.meamoria.lexurgy.inflect.*
import com.meamoria.lexurgy.word.Word

fun runInflect(request: Request): Response {
    val rules = rulesFromRequest(request.rules)
    val result = try {
        rules.inflectAll(
            *stemsAndCategoriesFromRequest(request.stemsAndCategories)
        )
    } catch (e: InflectUserError) {
        return ErrorResponse(e.message ?: "An unknown error occurred")
    }

    return SuccessResponse(formsToResponse(result))
}

private fun rulesFromRequest(requestRules: RequestCategoryTree): CategoryTree {
    return when (requestRules) {
        is RequestForm -> Form(requestRules.form)
        is RequestFormulaForm -> Form(formulaFromRequest(requestRules.formula))
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

private fun formulaFromRequest(formula: RequestFormula): Formula =
    when (formula) {
        is RequestStem -> Stem
        is RequestForm -> Fixed(formula.form)
        is RequestConcat -> Concat(formula.parts.map(::formulaFromRequest))
    }


private fun formsToResponse(forms: List<Word>): List<String> {
    return forms.map { it.string }
}
