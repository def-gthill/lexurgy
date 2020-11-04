package com.meamoria.mpp.kotest

expect abstract class StringSpec(body: StringSpec.() -> Unit) {
    operator fun String.invoke(test: suspend TestContext.() -> Unit)
}

expect interface TestContext

expect infix fun <T> T.should(matcher: (T) -> Unit)

expect infix fun <T, U : T> T.shouldBe(expected: U?)

expect inline fun <reified T : Any> Any?.shouldBeInstanceOf()

expect inline fun <reified T : Throwable> shouldThrow(block: () -> Any?): T

expect inline fun <T> shouldNotThrowAny(block: () -> T): T

expect fun startWith(prefix: String): (String?) -> Unit
