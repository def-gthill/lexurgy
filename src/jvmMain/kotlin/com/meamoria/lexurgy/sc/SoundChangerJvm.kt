package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import java.nio.file.Path
import kotlin.streams.toList
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

@ExperimentalTime
fun changeFiles(
    changesPath: Path,
    wordsPaths: List<Path>,
    startAt: String? = null,
    stopBefore: String? = null,
    inSuffix: String? = null,
    outSuffix: String = "ev",
    debugWords: List<String> = emptyList(),
    intermediates: Boolean = false,
    romanize: Boolean = true,
    compareStages: Boolean = false,
    compareVersions: Boolean = false
) {
    console("Loading sound changes from $changesPath")
    val changer = soundChangerFromLscFile(changesPath)
    changer.changeFiles(
        wordsPaths,
        startAt = startAt,
        stopBefore = stopBefore,
        inSuffix = inSuffix,
        outSuffix = outSuffix,
        debugWords = debugWords,
        intermediates = intermediates,
        romanize = romanize,
        compareStages = compareStages,
        compareVersions = compareVersions
    )
}

fun soundChangerFromLscFile(path: Path): SoundChanger =
    SoundChanger.fromLsc(path.toFile().readLines().joinToString("\n"))

@ExperimentalTime
fun SoundChanger.changeFiles(
    wordsPaths: List<Path>,
    startAt: String? = null,
    stopBefore: String? = null,
    inSuffix: String? = null,
    outSuffix: String = "ev",
    debugWords: List<String> = emptyList(),
    intermediates: Boolean = false,
    romanize: Boolean = true,
    compareStages: Boolean = false,
    compareVersions: Boolean = false
) {
    for (wordsPath in wordsPaths) {
        console("Applying changes to words in ${suffixPath(wordsPath, inSuffix)}")

        UnicodeLogger.path = suffixPath(wordsPath, "trace")

        val words = loadList(wordsPath, suffix = inSuffix)

        val (wordListSequence, time) = if (intermediates) {
            val (stages, time) = measureTimedValue {
                changeWithIntermediates(
                    words,
                    startAt = startAt,
                    stopBefore = stopBefore,
                    debugWords = debugWords,
                    romanize = romanize,
                    console = ::console,
                    debug = ::debug,
                )
            }

            val intermediateStages = stages.filterKeys { it != null }

            for ((name, stageWords) in intermediateStages) {
                dumpList(wordsPath, stageWords, suffix = name)
                console("Wrote the forms at stage $name to ${suffixPath(wordsPath, name)}")
            }

            TimedValue(
                listOf(words) + intermediateStages.values + listOf(stages.getValue(null)),
                time
            )
        } else {
            measureTimedValue {
                listOf(
                    words,
                    change(
                        words,
                        startAt = startAt,
                        stopBefore = stopBefore,
                        debugWords = debugWords,
                        romanize = romanize
                    )
                )
            }
        }

        val finalWords = wordListSequence.last()

        val stageCompare =
            if (compareStages) makeStageComparisons(wordListSequence) else finalWords

        val versionCompare =
            if (compareVersions) {
                val previous = loadList(wordsPath, suffix = outSuffix)
                makeVersionComparisons(finalWords, previous, stageCompare)
            } else stageCompare

        console(
            "Applied the changes to ${enpl(words.size, "word")} in ${"%.3f".format(time.inSeconds)} seconds"
        )

        dumpList(wordsPath, finalWords, suffix = outSuffix)
        console("Wrote the final forms to ${suffixPath(wordsPath, outSuffix)}")

        if (compareStages || compareVersions) {
            val markupPath = wordsPath.replaceExtension("wlm")
            dumpList(markupPath, versionCompare, suffix = outSuffix)
            console("Wrote comparison markup to ${suffixPath(markupPath, outSuffix)}")
        }
    }
}

private fun makeStageComparisons(wordListSequence: List<List<String>>): List<String> {
    val result = mutableListOf<String>()
    val maxLengths = wordListSequence.map { it.maxLength() }
    val iterators = wordListSequence.map { it.iterator() }
    while (iterators.all { it.hasNext() }) {
        val stages = iterators.map { it.next() }
        val resultLine =
            if (stages.all { it == stages.first() }) stages.first()
            else stages.zip(maxLengths) { stage, length ->
                stage.padEndCombining(length)
            }.joinToString(" => ").trim()
        result += resultLine
    }
    return result
}

private fun makeVersionComparisons(
    newWords: List<String>, previousWords: List<String>, stageCompare: List<String>
): List<String> {
    // If the list has changed length, the user has definitely changed the
    // input wordlist, so any comparisons are likely to be meaningless.
    if (newWords.size != previousWords.size) return stageCompare

    val maxLength = stageCompare.maxLength()
    return stageCompare.zip(
        newWords.zip(previousWords) { newWord, previousWord ->
            if (newWord == previousWord) null else previousWord
        }
    ) { compare, previousWord ->
        if (previousWord == null) compare
        else compare.padEndCombining(maxLength + 1) + "XX " + previousWord
    }
}

private fun Iterable<String>.maxLength(): Int = map { it.length }.maxOrNull() ?: 0

actual fun <T, U, R> Iterable<T>.fastZipMap(other: Iterable<U>, function: (T, U) -> R): List<R> =
    zip(other).parallelStream().map { function(it.first, it.second) }.toList()
