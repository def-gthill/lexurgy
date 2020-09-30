package com.meamoria.lexurgy.gen

class Generator(
    val rule: Generator.(Request) -> String,
    val subpatterns: Map<String, Generator> = emptyMap()
) {
    fun runRule(request: Request): String = rule(request)

    fun <T> choose(options: List<Pair<T, Number>>): T = TODO()

    fun runSubpattern(request: Request, name: String): String =
        subpatterns[name]?.runRule(request) ?: throw AwkwordsUndefinedName("subpattern", name)

    class Request private constructor(choices: List<Int> = emptyList(), randomNumbers: List<Double>)
}
