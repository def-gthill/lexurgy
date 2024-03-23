package com.meamoria.lexurgy.api.sc.v1

import com.meamoria.lexurgy.api.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.delay
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.*
import kotlin.system.measureNanoTime
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@Suppress("SameParameterValue")
class Scv1Test {
    @Test
    fun canApplyOneSoundChange() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "rule:\no => a",
                inputWords = listOf("foo", "oboe")
            )
        ).assertOkResponseIsJson(
            scv1Response(
                ruleNames = listOf("rule"),
                outputWords = listOf("faa", "abae")
            )
        )
    }

    @Test
    fun withIntermediateRomanizer_ReturnsIntermediateForms() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "rule-1:\n o => a\n\nromanizer-intermediate:\nunchanged\n\nrule-2:\n b => d",
                inputWords = listOf("foo", "oboe")
            )
        ).assertOkResponseIsJson(
            scv1Response(
                ruleNames = listOf("rule-1", "intermediate", "rule-2"),
                outputWords = listOf("faa", "adae"),
                intermediateWords = mapOf(
                    "intermediate" to listOf("faa", "abae")
                )
            )
        )
    }

    @Test
    fun withStartAt_StartsRuleApplicationsAtSpecifiedRule() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "a-to-b:\n a => b\n\nb-to-c:\n b => c\n\nc-to-d:\n c => d",
                inputWords = listOf("aaa", "bbb", "ccc"),
                startAt = "b-to-c",
            )
        ).assertOkResponseIsJson(
            scv1Response(
                ruleNames = listOf("a-to-b", "b-to-c", "c-to-d"),
                outputWords = listOf("aaa", "ddd", "ddd")
            )
        )
    }

    @Test
    fun withStopBefore_StopsRuleApplicationsBeforeSpecifiedRule() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "a-to-b:\n a => b\n\nb-to-c:\n b => c\n\nc-to-d:\n c => d",
                inputWords = listOf("aaa", "bbb", "ccc"),
                stopBefore = "c-to-d",
            )
        ).assertOkResponseIsJson(
            scv1Response(
                ruleNames = listOf("a-to-b", "b-to-c", "c-to-d"),
                outputWords = listOf("ccc", "ccc", "ccc")
            )
        )
    }

    @Test
    fun withTracingOneWord_ReturnsAllRuleApplicationsToTracedWord() = testApi {
        client.post("/scv1") {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            setBody(
                scv1Request(
                    changes = "a-to-b:\n a => b\n\nb-to-c:\n b => c\n\nc-to-d:\n c => d",
                    inputWords = listOf("aaa", "bbb", "ccc"),
                    traceWords = listOf("aaa"),
                )
            )
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals(
                scv1Response(
                    ruleNames = listOf("a-to-b", "b-to-c", "c-to-d"),
                    outputWords = listOf("ddd", "ddd", "ddd"),
                    traces = mapOf(
                        "aaa" to listOf(
                            "a-to-b" to "bbb",
                            "b-to-c" to "ccc",
                            "c-to-d" to "ddd"
                        ),
                    ),
                ),
                bodyAsText(),
            )
        }
    }

    @Test
    fun withTracingMultipleWords_ReturnsAllRuleApplicationsToTracedWords() = testApi {
        client.post("/scv1") {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            setBody(
                scv1Request(
                    changes = "a-to-b:\n a => b\n\nb-to-c:\n b => c\n\nc-to-d:\n c => d",
                    inputWords = listOf("aaa", "bbb", "ccc"),
                    traceWords = listOf("aaa", "ccc"),
                )
            )
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals(
                scv1Response(
                    ruleNames = listOf("a-to-b", "b-to-c", "c-to-d"),
                    outputWords = listOf("ddd", "ddd", "ddd"),
                    traces = mapOf(
                        "aaa" to listOf(
                            "a-to-b" to "bbb",
                            "b-to-c" to "ccc",
                            "c-to-d" to "ddd"
                        ),
                        "ccc" to listOf(
                            "c-to-d" to "ddd"
                        ),
                    ),
                ),
                bodyAsText(),
            )
        }
    }

    @Test
    fun onParseError_ReturnsBadRequestWithErrorDetails() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "bad-rule:\na =>",
                inputWords = listOf("aaa"),
            ),
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
    fun onInvalidRuleExpression_ReturnsBadRequestWithErrorDetails() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "foo:\n[+foo] => *",
                inputWords = listOf("foo"),
            ),
        ).apply {
            assertEquals(HttpStatusCode.BadRequest, status)
            val responseJson = Json.parseToJsonElement(bodyAsText()) as JsonObject
            assertEquals("invalidExpression", responseJson["type"]?.jsonPrimitive?.content)
            assertContains(responseJson, "message")
            assertContains(responseJson, "rule" )
            assertContains(responseJson, "expression" )
            assertContains(responseJson, "expressionNumber" )
        }
    }

    @Test
    fun onInvalidDeclaration_ReturnsBadRequest() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "Symbol x, x",
                inputWords = emptyList(),
            )
        ).apply {
            assertEquals(HttpStatusCode.BadRequest, status)
            val responseJson = Json.parseToJsonElement(bodyAsText()) as JsonObject
            assertEquals("analysisError", responseJson["type"]?.jsonPrimitive?.content)
            assertContains(responseJson, "message")
        }
    }

    @Test
    fun onRuleFailure_ReturnsListOfErrorsInSuccessResponse() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "foo:\n{f, b} => {m, $1}",
                inputWords = listOf("foo", "bar"),
            ),
        ).apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals(
                scv1Response(
                    ruleNames = listOf("foo"),
                    outputWords = listOf("moo", "ERROR"),
                    errors = listOf(
                        ruleFailure(
                            message = "Capture variable 1 referenced before being bound",
                            rule = "foo",
                            originalWord = "bar",
                            currentWord = "bar",
                        )
                    )
                ),
                bodyAsText(),
            )
        }
    }

    @Test
    fun onDanglingDiacriticInRules_ReturnsBadRequest() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "Feature +foo\nDiacritic ' [+foo]\nfoo:\n'o => a",
                inputWords = listOf("foo", "bor"),
            ),
        ).apply {
            assertEquals(HttpStatusCode.BadRequest, status)
        }
    }

    @Test
    fun onDanglingDiacriticInInputWord_ReturnsBadRequest() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "Feature +foo\nDiacritic ' [+foo]\nfoo:\no => a",
                inputWords = listOf("'foo", "bor"),
            ),
        ).apply {
            assertEquals(HttpStatusCode.BadRequest, status)
        }
    }

    @Test
    fun onExplodingRule_TimesOut() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "explode propagate:\na => aa",
                inputWords = listOf("foo", "bar"),
            ),
        ).apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals(
                1,
                Json.parseToJsonElement(bodyAsText()).jsonObject["errors"]?.jsonArray?.size
            )
        }
    }

    @Test
    fun onTooManyWords_TimesOut() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "mini-explode:\n(a+ a+)+ b => x",
                inputWords = generateSequence { "aaaaaaaa" }.take(10000).toList()
            )
        ).apply {
            assertEquals(HttpStatusCode.BadRequest, status)
        }
    }

    @Test
    fun withPollingEnabled_AppliesChanges() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "rule:\no => a",
                inputWords = listOf("foo", "oboe"),
                allowPolling = true,
            )
        ).assertOkResponseIsJson(
            scv1Response(
                ruleNames = listOf("rule"),
                outputWords = listOf("faa", "abae")
            )
        )
    }

    @Test
    fun withPollingEnabled_ReturnsAsSoonAsChangesFinish() =
        testApiWithRequestTimeout(5.0) {
            val time = measureNanoTime {
                client.postJson(
                    "/scv1",
                    scv1Request(
                        changes = "rule:\no => a",
                        inputWords = listOf("foo", "oboe"),
                        allowPolling = true,
                    )
                ).assertOkResponseIsJson(
                    scv1Response(
                        ruleNames = listOf("rule"),
                        outputWords = listOf("faa", "abae")
                    )
                )
            }
            assertTrue(time < 1e9)
        }

    @Test
    fun onTooManyWordsWithPollingEnabled_RunsInTheBackground() = testApi {
        client.postJson(
            "/scv1",
            scv1Request(
                changes = "mini-explode:\n(a+ a+)+ b => x",
                inputWords = generateSequence { "aaaaaaaa" }.take(10000).toList(),
                allowPolling = true,
            )
        ).apply {
            assertEquals(HttpStatusCode.Accepted, status)
        }
    }

    @Test
    fun onTooManyWordsWithPollingEnabled_CanGetResultsByPolling() =
        // Force polling with a ridiculously short timeot
        testApiWithRequestTimeout(1e-9) {
            var pollingUrl: String
            client.postJson(
                "/scv1",
                scv1Request(
                    changes = "rule:\no => a",
                    inputWords = listOf("foo", "oboe"),
                    allowPolling = true,
                )
            ).apply {
                assertEquals(HttpStatusCode.Accepted, status)
                pollingUrl = bodyAsJson().getValue("url").jsonPrimitive.content
            }
            var done = false
            for (i in 1..10) {
                client.get(pollingUrl).apply {
                    assertEquals(HttpStatusCode.OK, status)
                    val status = bodyAsJson().getValue("status").jsonPrimitive.content
                    if (status != "working") {
                        done = true
                        val result = bodyAsJson().getValue("result")
                        assertEquals(
                            result,
                            scv1ResponseObject(
                                ruleNames = listOf("rule"),
                                outputWords = listOf("faa", "abae")
                            )
                        )
                    }
                }
                delay(50)
            }
            assertTrue(done)
        }

    @Test
    fun onTooManyWordsForTotalTimeout_TimesOutEvenWithPolling() =
        testApiWithRequestTimeout(1e-9) {
            var pollingUrl: String
            client.postJson(
                "/scv1",
                scv1Request(
                    changes = "mini-explode:\n(a+ a+)+ b => x",
                    inputWords = generateSequence { "aaaaaaaa" }.take(10000).toList(),
                    allowPolling = true,
                )
            ).apply {
                assertEquals(HttpStatusCode.Accepted, status)
                pollingUrl = bodyAsJson().getValue("url").jsonPrimitive.content
            }
            var done = false
            for (i in 1..15) {
                client.get(pollingUrl).apply {
                    val status = bodyAsJson().getValue("status").jsonPrimitive.content
                    if (status != "working") {
                        done = true
                        assertEquals(HttpStatusCode.BadRequest, this.status)
                    }
                }
                delay(50)
            }
            assertTrue(done)
        }

    @Test
    fun withApiKeyCheckingAndNoApiKey_ReturnsUnauthorized() = testApiWithKey {
        client.post("/scv1").apply {
            assertEquals(HttpStatusCode.Unauthorized, status)
        }
    }

    @Test
    fun withApiKeyCheckingAndWrongApiKey_ReturnsForbidden() = testApiWithKey {
        client.post("/scv1") {
            header(HttpHeaders.Authorization, "someOtherKey")
        }.apply {
            assertEquals(HttpStatusCode.Forbidden, status)
        }
    }

    @Test
    fun withApiKeyCheckingAndCorrectApiKey_AppliesChanges() = testApiWithKey {
        client.post("/scv1") {
            header(HttpHeaders.Authorization, "myExampleKey")
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            setBody(
                scv1Request(
                    changes = "rule:\no => a",
                    inputWords = listOf("foo", "oboe")
                )
            )
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals(
                scv1Response(
                    ruleNames = listOf("rule"),
                    outputWords = listOf("faa", "abae")
                ),
                bodyAsText()
            )
        }
    }

    private fun scv1Request(
        changes: String,
        inputWords: List<String>,
        traceWords: List<String> = emptyList(),
        startAt: String? = null,
        stopBefore: String? = null,
        allowPolling: Boolean = false,
    ): String = buildJsonObject {
        put("changes", changes)
        putJsonArray("inputWords") {
            for (word in inputWords) {
                add(word)
            }
        }
        if (traceWords.isNotEmpty()) {
            putJsonArray("traceWords") {
                for (word in traceWords) {
                    add(word)
                }
            }
        }
        if (startAt != null) {
            put("startAt", startAt)
        }
        if (stopBefore != null) {
            put("stopBefore", stopBefore)
        }
        if (allowPolling) {
            put("allowPolling", true)
        }
    }.toString()

    private fun scv1Response(
        ruleNames: List<String>,
        outputWords: List<String>,
        intermediateWords: Map<String, List<String>> = emptyMap(),
        traces: Map<String, List<Pair<String, String>>> = emptyMap(),
        errors: List<JsonObject> = emptyList(),
    ): String = scv1ResponseObject(
        ruleNames = ruleNames,
        outputWords = outputWords,
        intermediateWords = intermediateWords,
        traces = traces,
        errors = errors,
    ).toString()

    private fun scv1ResponseObject(
        ruleNames: List<String>,
        outputWords: List<String>,
        intermediateWords: Map<String, List<String>> = emptyMap(),
        traces: Map<String, List<Pair<String, String>>> = emptyMap(),
        errors: List<JsonObject> = emptyList(),
    ): JsonObject = buildJsonObject {
        putJsonArray("ruleNames") {
            for (name in ruleNames) {
                add(name)
            }
        }
        putJsonArray("outputWords") {
            for (word in outputWords) {
                add(word)
            }
        }
        if (intermediateWords.isNotEmpty()) {
            putJsonObject("intermediateWords") {
                for ((stageName, stage) in intermediateWords) {
                    putJsonArray(stageName) {
                        for (word in stage) {
                            add(word)
                        }
                    }
                }
            }
        }
        if (traces.isNotEmpty()) {
            putJsonObject("traces") {
                for ((word, steps) in traces) {
                    putJsonArray(word) {
                        for ((stepName, result) in steps) {
                            addJsonObject {
                                put("rule", stepName)
                                put("output", result)
                            }
                        }
                    }
                }
            }
        }
        if (errors.isNotEmpty()) {
            putJsonArray("errors") {
                for (error in errors) {
                    add(error)
                }
            }
        }
    }

    private fun ruleFailure(
        message: String,
        rule: String,
        originalWord: String,
        currentWord: String,
    ): JsonObject = buildJsonObject {
        put("message", message)
        put("rule", rule)
        put("originalWord", originalWord)
        put("currentWord", currentWord)
    }

    private suspend fun HttpResponse.bodyAsJson(): JsonObject =
        Json.decodeFromString<JsonObject>(bodyAsText())
}
