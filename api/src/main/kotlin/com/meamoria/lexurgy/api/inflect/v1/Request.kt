package com.meamoria.lexurgy.api.inflect.v1

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Request(
    val rules: RequestCategoryTree,
    val stemsAndCategories: List<RequestStemAndCategories>
)

@Serializable
sealed interface RequestCategoryTree

@Serializable
@SerialName("form")
data class RequestForm(val form: String) : RequestCategoryTree, RequestFormula

@Serializable
@SerialName("formula")
data class RequestFormulaForm(
    val formula: RequestFormula
) : RequestCategoryTree

@Serializable
@SerialName("split")
data class RequestCategorySplit(
    val branches: Map<String, RequestCategoryTree>
) : RequestCategoryTree

@Serializable
data class RequestStemAndCategories(
    val stem: String,
    val categories: List<String>
)

@Serializable
sealed interface RequestFormula

@Serializable
@SerialName("stem")
object RequestStem : RequestFormula

@Serializable
@SerialName("concat")
data class RequestConcat(
    val parts: List<RequestFormula>
) : RequestFormula
