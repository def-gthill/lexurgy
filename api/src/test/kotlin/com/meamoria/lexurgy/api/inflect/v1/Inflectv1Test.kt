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
            inflectv1Request(
                rules = "foo",
                stemsAndCategories = listOf(
                    "bar" to emptyList()
                )
            )
        ).assertOkResponseIsJson(
            inflectv1Response(
                listOf("foo")
            )
        )
    }

    private fun inflectv1Request(
        rules: String,
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

    private fun inflectv1Response(
        inflectedForms: List<String>
    ): String = buildJsonObject {
        putJsonArray("inflectedForms") {
            for (form in inflectedForms) {
                add(form)
            }
        }
    }.toString()
}
