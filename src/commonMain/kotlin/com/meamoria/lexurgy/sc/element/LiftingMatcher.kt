package com.meamoria.lexurgy.sc.element

/**
 * A matcher whose response to all emitters is to try to connect
 * a sub-element to the emitter.
 */
abstract class LiftingMatcher : BaseMatcher() {
    override fun transformerToAlternatives(
        result: AlternativeEmitter,
        filtered: Boolean
    ): Transformer = liftingTransformerTo(result, filtered)

    override fun transformerToSequence(
        result: SequenceEmitter,
        filtered: Boolean
    ): Transformer = liftingTransformerTo(result, filtered)

    override fun transformerToConditional(
        result: ConditionalEmitter,
        filtered: Boolean
    ): Transformer = liftingTransformerTo(result, filtered)

    protected abstract fun liftingTransformerTo(
        result: Emitter,
        filtered: Boolean
    ): Transformer
}