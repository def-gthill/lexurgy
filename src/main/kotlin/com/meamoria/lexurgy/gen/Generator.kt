package com.meamoria.lexurgy.gen

import kotlin.random.Random

/**
 * A rule for generating word fragments on request
 */
interface Generator {
    fun runRule(request: Request): String

    fun <T> choose(options: List<Pair<T, Number>>): T = TODO()

    /**
     * A request for a word fragment. By default, this will request
     * a random word fragment, according to the implementation's
     * definition of random. The choices can be controlled in two
     * ways for testing; either the index of each choice can be
     * provided as ``choices``, or presampled random numbers
     * between 0 and 1 can be provided as ``randomNumbers``.
     *
     * If the generator has to make more choices than are
     * provided, it will revert to choosing randomly for
     * the remaining choices. If both arguments are provided,
     * ``choices`` will be used first, then ``randomNumbers``
     * will be used once ``choices`` is exhausted.
     */
    class Request private constructor(
        val choices: Iterator<Int> = emptySequence<Int>().iterator(),
        val randomNumbers: Iterator<Double> = emptySequence<Double>().iterator()
    )
}

fun atomGenerator(text: String): Generator = Atom(text)

/**
 * A generator that always generates a specific string.
 */
class Atom(val text: String) : Generator {
    override fun runRule(request: Generator.Request): String = text

    override fun toString(): String = "Atom($text)"
}

fun sequenceGenerator(elements: List<Generator>): Generator = Sequence(elements)

/**
 * A generator that concatenates the results of a sequence of sub-generators.
 */
class Sequence(val elements: List<Generator>) : Generator {
    override fun runRule(request: Generator.Request): String =
        elements.joinToString(separator = "") { runRule(request) }

    override fun toString(): String = "Sequence(${elements.joinToString()}"
}

fun optionalGenerator(element: Generator, probability: Double) : Generator =
    Alternatives(listOf(Alternative(Atom(""), 1 - probability), Alternative(element, probability)))

fun alternativesGenerator(alternatives: List<Alternative>) : Generator =
    Alternatives(alternatives)

/**
 * A generator that randomly chooses one of its alternatives,
 * with probabilities proportional to their weights.
 */
class Alternatives(val alternatives: List<Alternative>) : Generator {
    constructor(vararg alternatives: Alternative) : this(alternatives.toList())

    override fun runRule(request: Generator.Request): String =
        if (request.choices.hasNext()) {
            alternatives[request.choices.next()].alternative.runRule(request)
        } else {
            val cumes = alternatives.scan(0.0) { acc, alternative ->
                acc + alternative.weight
            }
            val randomNumber = if (request.randomNumbers.hasNext()) {
                request.randomNumbers.next()
            } else {
                Random.Default.nextDouble()
            }
            val index = cumes.indexOfFirst { it > randomNumber }
            alternatives[index].alternative.runRule(request)
        }

    override fun toString(): String = "Alternatives(${alternatives.joinToString()}"
}

data class Alternative(val alternative: Generator, val weight: Double) {
    override fun toString(): String = "$alternative(*$weight)"
}
