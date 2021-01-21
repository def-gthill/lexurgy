package com.meamoria.lexurgy.gen

class AwkwordsGeneratorWalker {
//    override fun walkAlternative(elements: List<GeneratorNode>): GeneratorNode =
//        GeneratorNode { request -> choose(elements.map { it to it.weight }).runRule(request) }
//
//    override fun walkOptional(element: GeneratorNode): GeneratorNode =
//        GeneratorNode { if (choose(listOf(false to 1, true to 1))) element.runRule(it) else "" }
//
//    override fun walkSequence(elements: List<GeneratorNode>): GeneratorNode =
//        GeneratorNode { request -> elements.joinToString("") { it.runRule(request) } }
//
//    override fun walkSubref(name: String): GeneratorNode = GeneratorNode { runSubpattern(it, name) }
//
//    override fun walkAtom(text: String): GeneratorNode = GeneratorNode { text }
//
//    class GeneratorNode(val generator: Generator, val name: String? = null, val weight: Int = 0) {
//        constructor(generatorRule: Generator.(Generator.Request) -> String) :
//                this(Generator(generatorRule))
//
//        fun runRule(request: Generator.Request): String = generator.runRule(request)
//    }
}
