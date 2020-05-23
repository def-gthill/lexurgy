package com.meamoria.lexurgy.gen

class AwkwordsGeneratorWalker : AwkwordsWalker<AwkwordsGeneratorWalker.GeneratorNode>() {
    override fun walkAlternative(elements: List<GeneratorNode>): GeneratorNode =
        GeneratorNode { request -> choose(elements.map { it to it.weight }).runRule(request) }

    override fun walkOptional(element: GeneratorNode): GeneratorNode =
        GeneratorNode { if (choose(listOf(false to 1, true to 1))) element.runRule(it) else "" }

    override fun walkSequence(elements: List<GeneratorNode>): GeneratorNode =
        GeneratorNode { request -> elements.joinToString("") { it.runRule(request) } }

    override fun walkSubref(name: String): GeneratorNode = GeneratorNode { runSubpattern(it, name) }

    override fun walkAtom(text: String): GeneratorNode = GeneratorNode { text }

    class GeneratorNode(val generator: AwkwordsGenerator, val name: String? = null, val weight: Int = 0) {
        constructor(generatorRule: AwkwordsGenerator.(AwkwordsGenerator.Request) -> String) :
                this(AwkwordsGenerator(generatorRule))

        fun runRule(request: AwkwordsGenerator.Request): String = generator.runRule(request)
    }
}
