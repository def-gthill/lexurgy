package com.meamoria.lexurgy.sc

sealed class SubSequence<out T> {
    abstract fun <R> map(transform: (T) -> R): SubSequence<R>
}

/**
 * There are no accessible sequences in this element.
 */
object NonSequence : SubSequence<Nothing>() {
    override fun <R> map(transform: (Nothing) -> R): SubSequence<R> = this
}

/**
 * There is an accessible sequence with a definite length,
 * allowing retrieval of the individual elements.
 */
class DefiniteSequence<T>(val elements: List<T>) : SubSequence<T>() {
    val length: Int = elements.size

    override fun <R> map(transform: (T) -> R): SubSequence<R> =
        DefiniteSequence(elements.map(transform))
}

/**
 * There is an accessible sequence whose length isn't
 * known at parse time.
 * We can retrieve typical elements, but not the full
 * list of elements.
 */
class IndefiniteSequence<T>(val typicalElements: List<T>) : SubSequence<T>() {
    override fun <R> map(transform: (T) -> R): SubSequence<R> =
        IndefiniteSequence(typicalElements.map(transform))
}

sealed class SubAlternatives<out T> {
    abstract fun <R> map(transform: (T) -> R): SubAlternatives<R>
}

object OneAlternative : SubAlternatives<Nothing>() {
    override fun <R> map(transform: (Nothing) -> R): SubAlternatives<R> = this
}

class ManyAlternatives<T>(val elements: List<T>) : SubAlternatives<T>() {
    val length: Int = elements.size

    override fun <R> map(transform: (T) -> R): SubAlternatives<R> =
        ManyAlternatives(elements.map(transform))
}
