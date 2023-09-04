package com.meamoria.lexurgy.api.inflect.v1

import com.meamoria.lexurgy.inflect.*
import com.meamoria.lexurgy.word.Word
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Request(
    val rules: RequestCategoryTree,
    val stemsAndCategories: List<RequestStemAndCategories>
)

@Serializable
sealed interface RequestCategoryTree {
    fun toRules(): CategoryTree
}

@Serializable
@SerialName("form")
data class RequestForm(val form: String) : RequestCategoryTree, RequestFormula {
    override fun toRules(): Form = Form(form)

    override fun toFormula(): Fixed = Fixed(form)
}

@Serializable
@SerialName("formula")
data class RequestFormulaForm(
    val formula: RequestFormula
) : RequestCategoryTree {
    override fun toRules(): Form = Form(formula.toFormula())
}

@Serializable
@SerialName("split")
data class RequestCategorySplit(
    val branches: Map<String, RequestCategoryTree>
) : RequestCategoryTree {
    override fun toRules(): CategorySplit =
        CategorySplit(branches.mapValues { it.value.toRules() })
}

@Serializable
sealed interface RequestFormula {
    fun toFormula(): Formula
}

@Serializable
@SerialName("stem")
object RequestStem : RequestFormula {
    override fun toFormula(): Stem = Stem
}

@Serializable
@SerialName("concat")
data class RequestConcat(
    val parts: List<RequestFormula>
) : RequestFormula {
    override fun toFormula(): Concat =
        Concat(parts.map { it.toFormula() })
}

@Serializable
data class RequestStemAndCategories(
    val stem: String,
    val categories: List<String>
) {
    fun toStemAndCategories(): StemAndCategories {
        return Word(stem) to categories.toSet()
    }
}
