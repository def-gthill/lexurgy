package com.meamoria.lexurgy.sc.element

/**
 * A matcher that isn't a container for other matchers
 */
abstract class SimpleMatcher : BaseMatcher() {
    override fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean
    ): Transformer = mismatchedLengths(this, result, listOf(this), result.elements)

    override fun transformerToSequence(
        result: SequenceEmitter,
        filtered: Boolean
    ): Transformer = mismatchedLengths(this, result, listOf(this), result.elements)

    override fun transformerToConditional(
        result: ConditionalEmitter,
        filtered: Boolean
    ): Transformer = SimpleConditionalTransformer(this, result)

    override fun transformerToIndependent(
        result: IndependentEmitter,
        filtered: Boolean
    ): Transformer = IndependentTransformer(this, result)

    override fun transformerToIndependentSequence(
        result: SequenceEmitter,
        filtered: Boolean
    ): Transformer = IndependentSequenceTransformer(this, result)
}