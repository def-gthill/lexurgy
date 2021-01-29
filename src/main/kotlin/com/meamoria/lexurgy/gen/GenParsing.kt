package com.meamoria.lexurgy.gen

interface ParseNode {
    val text: String
}

/**
 * A node that returns a generator, possibly retrieving
 * references from the given declarations
 */
interface GeneratorNode : ParseNode {
    /**
     * Retrieves the generator represented by this parse tree node
     */
    fun generator(declarations: Declarations): Generator
}

internal abstract class ToStringIsText : ParseNode {
    override fun toString(): String = text
}

/**
 * A simple container for text
 */
internal class TextNode(override val text: String) : ToStringIsText()

internal class ReferenceNode(val refType: String, val shortRefType: String, val name: String) :
    ToStringIsText(), GeneratorNode {

    override val text: String = "$shortRefType($name)"

    override fun generator(declarations: Declarations): Generator = declarations.resolve(refType, name)
}

internal class ConstantNode(override val text: String) : ToStringIsText(), GeneratorNode {
    override fun generator(declarations: Declarations): Generator = atomGenerator(text)
}

internal class OptionalNode(val element: GeneratorNode, val probability: Double) :
    ToStringIsText(), GeneratorNode {

    override val text: String = "op($element)"

    override fun generator(declarations: Declarations): Generator =
        optionalGenerator(element.generator(declarations), probability)
}

internal class AlternativeNode(val elements: List<GeneratorNode>) : ToStringIsText(), GeneratorNode {
    override val text: String = "alt(${elements.joinToString()})"

    override fun generator(declarations: Declarations): Generator =
        alternativesGenerator(elements.map { Alternative(it.generator(declarations), 1.0 / elements.size) })
}

internal class SequenceNode(val elements: List<GeneratorNode>) : ToStringIsText(), GeneratorNode {
    override val text: String = "seq(${elements.joinToString()})"

    override fun generator(declarations: Declarations): Generator =
        sequenceGenerator(elements.map { it.generator(declarations) })
}

class Declarations(val declarations: Map<String, GeneratorNode>) {
    private val resolvedDeclarations = mutableMapOf<String, Generator>()

    fun resolve(refType: String, name: String): Generator = resolvedDeclarations[name] ?: (
            declarations[name]?.generator(this)?.also {
                resolvedDeclarations[name] = it
            } ?: throw GenUndefinedName(refType, name))
}

class GenUndefinedName(val nameType: String, val undefinedName: String) :
    Exception("The $nameType name $undefinedName is not defined")
