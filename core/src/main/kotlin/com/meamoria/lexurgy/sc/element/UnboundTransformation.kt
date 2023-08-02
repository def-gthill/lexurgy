package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.word.Phrase
import com.meamoria.lexurgy.word.PhraseIndex
import com.meamoria.lexurgy.sc.Bindings

data class UnboundTransformation(
    val order: Int,
    val start: PhraseIndex,
    val end: PhraseIndex,
    val result: UnboundResult,
    val returnBindings: Bindings,
    val subs: List<UnboundTransformation> = emptyList(),
    val removesSyllableBreaks: List<PhraseIndex> = emptyList(),
) : WithBindings<UnboundTransformation> {
    val removesSyllableBreakBefore: Boolean = removesSyllableBreaks.firstOrNull() == start
    val removesSyllableBreakAfter: Boolean = removesSyllableBreaks.lastOrNull() == end

    fun bindVariablesCatching(bindings: Bindings = returnBindings): TransformationCatching {
        val boundResult = runCatching {
            result.bind(bindings)
        }
        return TransformationCatching(
            order,
            start,
            end,
            boundResult,
            subs.map { it.bindVariablesCatching(bindings) },
            removesSyllableBreaks,
        )
    }

    override fun replaceBindings(bindings: Bindings): UnboundTransformation =
        copy(returnBindings = bindings)

    override fun updateBindings(bindings: Bindings): UnboundTransformation =
        copy(returnBindings = returnBindings.combine(bindings))

    fun toMatchEnd(): PhraseMatchEnd =
        PhraseMatchEnd(end, returnBindings)

    override fun toString(): String {
        val tryResult = try {
            result.bind(Bindings()).phrase.string
        } catch (e: Exception) {
            "<unbound>"
        }
        return "UnboundTransformation($order, $start to $end, $tryResult, binding $returnBindings, ${subs.size} subs"
    }

    companion object {
        fun fromSubTransformations(
            order: Int,
            start: PhraseIndex,
            bindings: Bindings,
            subs: List<UnboundTransformation>,
        ): UnboundTransformation {
            val unboundResult = UnboundResult { finalBindings ->
                val (nonEmptySubs, results) = subs.map {
                    it to it.result.bind(finalBindings)
                }.filter {
                    it.second.phrase.words.isNotEmpty()
                }.unzip()

                val resultPhrases = results.map { it.phrase }

                val subPhrases = mutableListOf<Phrase>()
                for ((i, sub) in nonEmptySubs.withIndex()) {
                    var subPhrase = resultPhrases[i]

                    if (!results[i].emitsSyllableBreakBefore) {
                        val previousRemovesSyllableBreakAfter =
                            i > 0 && nonEmptySubs[i - 1].removesSyllableBreakAfter
                        if (
                            sub.removesSyllableBreakBefore ||
                            previousRemovesSyllableBreakAfter
                        ) subPhrase = subPhrase.removeLeadingBreak()
                    }

                    if (!results[i].emitsSyllableBreakAfter) {
                        val nextRemovesSyllableBreakBefore =
                            i < nonEmptySubs.indices.last &&
                                    nonEmptySubs[i + 1].removesSyllableBreakBefore
                        if (
                            sub.removesSyllableBreakAfter ||
                            nextRemovesSyllableBreakBefore
                        ) subPhrase = subPhrase.removeTrailingBreak()
                    }

                    subPhrases += subPhrase
                }

                val resultPhrase = Phrase.fromSubPhrases(subPhrases)
                val resultEmitsSyllableBreaks = results.sequenceEmitsSyllableBreaks()
                val resultSyllableFeatureChanges = results.sequenceSyllableFeatureChanges()

                ChangeResult(
                    resultPhrase,
                    resultEmitsSyllableBreaks,
                    resultSyllableFeatureChanges,
                )
            }

            return UnboundTransformation(
                order,
                start,
                subs.lastOrNull()?.end ?: start,
                unboundResult,
                subs.lastOrNull()?.returnBindings ?: bindings,
                subs,
                subs.flatMap { it.removesSyllableBreaks }.distinct(),
            )
        }
    }
}