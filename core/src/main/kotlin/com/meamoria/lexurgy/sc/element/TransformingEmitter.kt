package com.meamoria.lexurgy.sc.element

class TransformingEmitter(
    val initialEmitter: IndependentEmitter,
    val transformation: ConditionalEmitter,
) : IndependentEmitter {
    override fun result(): UnboundResult =
        UnboundResult { bindings ->
            val initialResult = initialEmitter.result().bind(bindings)
            transformation.result(NeverMatcher, initialResult.phrase).bind(bindings)
        }
}