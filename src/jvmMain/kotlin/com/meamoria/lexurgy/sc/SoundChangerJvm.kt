package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.*
import java.io.FileNotFoundException
import java.nio.file.Path
import java.util.concurrent.TimeUnit
import kotlin.streams.toList
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue
import kotlin.time.measureTimedValue

class JavaKotlinBridgeSoundChanger(rules: String) {

    private val sc = SoundChanger.fromLsc(rules)

    fun change(
        words: List<String>,
        startAt: String?,
        stopBefore: String?,
        debugWords: List<String>,
        romanize: Boolean,
        debug: (String) -> Unit,
    ): List<String> = sc.change(
        words,
        startAt = startAt,
        stopBefore = stopBefore,
        debugWords = debugWords,
        romanize = romanize,
        debug = debug,
    )

    fun changeWithIntermediates(
        words: List<String>,
        startAt: String?,
        stopBefore: String?,
        debugWords: List<String>,
        romanize: Boolean,
        debug: (String) -> Unit,
    ): Map<String?, List<String>> = sc.changeWithIntermediates(
        words,
        startAt = startAt,
        stopBefore = stopBefore,
        debugWords = debugWords,
        romanize = romanize,
        debug = debug,
    )
}

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

        val previous = if (compareVersions) {
            try {
                loadList(wordsPath, suffix = outSuffix)
            } catch (e: FileNotFoundException) {
                throw LscFileNotFound(suffixPath(wordsPath, outSuffix))
            }
        } else null

        val (wordListSequence, time) = if (intermediates) {
            val (stages, time) = measureTimedValue {
                changeWithIntermediates(
                    words,
                    startAt = startAt,
                    stopBefore = stopBefore,
                    debugWords = debugWords,
                    romanize = romanize,
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
                makeVersionComparisons(finalWords, previous!!, stageCompare)
            } else stageCompare

        console(
            "Applied the changes to ${enpl(words.size, "word")} in ${"%.3f".format(time.toDouble(TimeUnit.SECONDS))} seconds"
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

actual fun <T, U, R> Iterable<T>.fastZipMap(other: Iterable<U>, function: (T, U) -> R): List<R> =
    zip(other).parallelStream().map { function(it.first, it.second) }.toList()

class LscFileNotFound(path: Path) : LscUserError(
    "Can't compare output words to ${path.fileName}; the file doesn't exist"
)
