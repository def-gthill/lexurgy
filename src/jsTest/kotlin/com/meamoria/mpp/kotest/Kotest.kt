package com.meamoria.mpp.kotest

import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestContext
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldNotThrowAny

actual typealias StringSpec = StringSpec

actual typealias TestContext = TestContext

actual infix fun <T> T.should(matcher: (T) -> Unit) = should(matcher)

actual infix fun <T, U : T> T.shouldBe(expected: U?) = shouldBe(expected)

actual inline fun <reified T : Any> Any?.shouldBeInstanceOf() = shouldBeInstanceOf<T>()

actual inline fun <reified T : Throwable> shouldThrow(block: () -> Any?): T = shouldThrow(block)

actual inline fun <T> shouldNotThrowAny(block: () -> T): T = shouldNotThrowAny(block)

actual fun startWith(prefix: String): (String?) -> Unit = { startWith(prefix) }