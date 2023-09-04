package com.meamoria.lexurgy.api.inflect.v1

import com.meamoria.lexurgy.api.assertOkResponseIsJson
import com.meamoria.lexurgy.api.postJson
import com.meamoria.lexurgy.api.testApi
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.json.*
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class Inflectv1Test {
    @Test
    fun canInflectWithOneForm() = testApi {
        postToInflect(
            rules = form("foo"),
            stemsAndCategories = listOf(
                "bar" to emptyList()
            )
        ).assertInflectedFormsAre("foo")
    }

    @Test
    fun canInflectWithCategories() = testApi {
        postToInflect(
            rules = categorySplit(
                "present" to form("foo"),
                "past" to form("fid"),
            ),
            stemsAndCategories = listOf(
                "bar" to listOf("past"),
                "bar" to listOf("present"),
            )
        ).assertInflectedFormsAre("fid", "foo")
    }

    @Test
    fun onUndeclaredCategory_ReturnsBadRequest() = testApi {
        postToInflect(
            rules = categorySplit(
                "present" to form("foo"),
            ),
            stemsAndCategories = listOf(
                "bar" to listOf("past"),
            )
        ).apply {
            assertEquals(HttpStatusCode.BadRequest, status)
            val responseJson = Json.parseToJsonElement(bodyAsText()) as JsonObject
            assertContains(responseJson, "message")
        }
    }

    @Test
    fun canInflectWithStemVariable() = testApi {
        postToInflect(
            rules = categorySplit(
                "stem" to formula(stem()),
                "fixed" to form("fixed"),
            ),
            stemsAndCategories = listOf(
                "foo" to listOf("fixed"),
                "foo" to listOf("stem"),
            )
        ).assertInflectedFormsAre("fixed", "foo")
    }

    @Test
    fun canInflectWithConcat() = testApi {
        postToInflect(
            rules = formula(concat(form("pre"), stem())),
            stemsAndCategories = listOf(
                "bar" to emptyList()
            )
        ).assertInflectedFormsAre("prebar")
    }

    private suspend fun ApplicationTestBuilder.postToInflect(
        rules: JsonElement,
        stemsAndCategories: List<Pair<String, List<String>>>,
    ): HttpResponse =
        client.postJson(
            "/inflectv1",
            request(
                rules = rules,
                stemsAndCategories = stemsAndCategories,
            )
        )

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

    private fun form(form: String): JsonElement =
        buildJsonObject {
            put("type", "form")
            put("form", form)
        }

    private fun formula(formula: JsonElement): JsonElement =
        buildJsonObject {
            put("type", "formula")
            put("formula", formula)
        }

    private fun categorySplit(
        vararg branches: Pair<String, JsonElement>
    ): JsonElement =
        buildJsonObject {
            put("type", "split")
            putJsonObject("branches") {
                for ((category, branch) in branches) {
                    put(category, branch)
                }
            }
        }

    private fun stem(): JsonElement =
        buildJsonObject {
            put("type", "stem")
        }

    private fun concat(vararg parts: JsonElement) =
        buildJsonObject {
            put("type", "concat")
            putJsonArray("parts") {
                for (part in parts) {
                    add(part)
                }
            }
        }

    private suspend fun HttpResponse.assertInflectedFormsAre(
        vararg inflectedForms: String
    ) {
        assertOkResponseIsJson(response(inflectedForms.asList()))
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
