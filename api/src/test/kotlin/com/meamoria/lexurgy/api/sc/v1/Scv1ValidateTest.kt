package com.meamoria.lexurgy.api.sc.v1

import com.meamoria.lexurgy.api.postJson
import com.meamoria.lexurgy.api.testApi
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class Scv1ValidateTest {
    @Test
    fun validate_WithValidRules_ReturnsRuleNames() = testApi {
        client.postJson(
            "/scv1/validate",
            """{"changes": "aaa:\nunchanged\n\nbbb:\nunchanged\n\nccc:\nunchanged"}"""
        ).apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("""{"ruleNames":["aaa","bbb","ccc"]}""", bodyAsText())
        }
    }

    @Test
    fun onParseError_ReturnsBadRequestWithErrorDetails() = testApi {
        client.postJson(
            "/scv1/validate",
            """{"changes": "bad-rule:\na =>"}"""
        ).apply {
            assertEquals(HttpStatusCode.BadRequest, status)
            val responseJson = Json.parseToJsonElement(bodyAsText()) as JsonObject
            assertEquals("parseError", responseJson["type"]?.jsonPrimitive?.content)
            assertContains(responseJson, "message")
            assertContains(responseJson, "lineNumber")
            assertContains(responseJson, "columnNumber")
        }
    }

    @Test
    fun onInvalidDeclaration_ReturnsBadRequest() = testApi {
        client.postJson(
            "/scv1/validate",
            """{"changes": "Symbol x, x"}"""
        ).apply {
            assertEquals(HttpStatusCode.BadRequest, status)
            val responseJson = Json.parseToJsonElement(bodyAsText()) as JsonObject
            assertEquals("analysisError", responseJson["type"]?.jsonPrimitive?.content)
            assertContains(responseJson, "message")
        }
    }
}
