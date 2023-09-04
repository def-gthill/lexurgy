package com.meamoria.lexurgy.api.inflect.v1

import com.meamoria.lexurgy.inflect.*
import com.meamoria.lexurgy.word.Word

fun runInflect(request: Request): Response {
    val rules = request.rules.toRules()
    val result = try {
        rules.inflectAll(
            *stemsAndCategoriesFromRequest(request.stemsAndCategories)
        )
    } catch (e: InflectUserError) {
        return ErrorResponse(e.message ?: "An unknown error occurred")
    }

    return SuccessResponse(formsToResponse(result))
}

private fun stemsAndCategoriesFromRequest(
    requestStemsAndCategories: List<RequestStemAndCategories>
): Array<StemAndCategories> {
    return requestStemsAndCategories
        .map { it.toStemAndCategories() }
        .toTypedArray()
}

private fun formsToResponse(forms: List<Word>): List<String> {
    return forms.map { it.string }
}
