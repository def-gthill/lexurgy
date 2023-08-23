package com.meamoria.lexurgy.api.inflect.v1

import com.meamoria.lexurgy.api.assertOkResponseIsJson
import com.meamoria.lexurgy.api.postJson
import com.meamoria.lexurgy.api.testApi
import kotlinx.serialization.json.*
import kotlin.test.Test

class Inflectv1Test {
    @Test
    fun canInflectWithOneForm() = testApi {
        client.postJson(
            "/inflectv1",
            request(
                rules = form("foo"),
                stemsAndCategories = listOf(
                    "bar" to emptyList()
                )
            )
        ).assertOkResponseIsJson(
            response(
                listOf("foo")
            )
        )
    }

    @Test
    fun canInflectWithCategories() = testApi {
        client.postJson(
            "/inflectv1",
            request(
                rules = categorySplit(
                    "present" to form("foo"),
                    "past" to form("fid"),
                ),
                stemsAndCategories = listOf(
                    "bar" to listOf("past"),
                    "bar" to listOf("present"),
                )
            )
        ).assertOkResponseIsJson(
            response(
                listOf("fid", "foo")
            )
        )
    }

    private fun request(
        rules: JsonElement,
        stemsAndCategories: List<Pair<String, List<String>>>,
    ): String = buildJsonObject {
        put("rules", rules)
        putJsonArray("stemsAndCategories") {
            for ((stem, categories) in stemsAndCategories) {
                addJsonObject {
                    put("stem", stem)
                    putJsonArray("categories") {
                        for (category in categories) {
                            add(category)
                        }
                    }
                }
            }
        }
    }.toString()

    private fun form(form: String): JsonElement {
        return buildJsonObject {
            put("type", "form")
            put("form", form)
        }
    }

    private fun categorySplit(
        vararg branches: Pair<String, JsonElement>
    ): JsonElement {
        return buildJsonObject {
            put("type", "split")
            putJsonObject("branches") {
                for ((category, branch) in branches) {
                    put(category, branch)
                }
            }
        }
    }

    private fun response(
        inflectedForms: List<String>
    ): String = buildJsonObject {
        putJsonArray("inflectedForms") {
            for (form in inflectedForms) {
                add(form)
            }
        }
    }.toString()
}
