package com.meamoria.lexurgy.gen

class AwkwordsGenerator(
    val rule: AwkwordsGenerator.(Request) -> String,
    val subpatterns: Map<String, AwkwordsGenerator> = emptyMap()
) {
    fun runRule(request: Request): String = rule(request)

    fun <T> choose(options: List<Pair<T, Number>>): T = TODO()

    fun runSubpattern(request: Request, name: String): String =
        subpatterns[name]?.runRule(request) ?: throw AwkwordsUndefinedName("subpattern", name)

    class Request private constructor(choices: List<Int> = emptyList(), randomNumbers: List<Double>)
}
