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
data class RequestForm(val form: String) : RequestCategoryTree

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
