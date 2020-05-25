package com.meamoria.lexurgy

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.multiple
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.multiple
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.path
import com.meamoria.lexurgy.sc.SoundChanger
import kotlin.time.ExperimentalTime

class Lexurgy : CliktCommand() {
    override fun run() = Unit
}

class SC : CliktCommand(
    help = "Applies sound changes from CHANGES (a .lsc file) to the words in WORDS (one or more .wli files). " +
            "By default, the output files have the suffix \"_ev\" added, but this can be changed with the --out-suffix option."
) {
    val changes by argument().path(mustBeReadable = true)
    val words by argument().path().multiple()
    val startAt by option(
        "-a", "--start-at",
        help = "The rule to start at. Lexurgy will apply this change and all subsequent changes."
    )
    val stopBefore by option(
        "-b", "--stop-before",
        help = "The rule to stop before. Lexurgy will apply all changes before the specified rule."
    )
    val inSuffix by option(
        "-i", "--in-suffix",
        help = "The suffix on the input filenames in WORDS. " +
                "E.g. if this is \"old\" and WORDS is \"foo.wli\", Lexurgy will read words from foo_old.wli instead."
    )
    val outSuffix by option(
        "-o", "--out-suffix",
        help = "The suffix on the output filenames. " +
                "E.g. if this is \"new\" and WORDS is \"foo.wli\", Lexurgy will write the changed words to foo_new.wli. " +
                "Defaults to \"ev\"."
    ).default("ev")
    val traceWords by option(
        "-t", "--trace-word",
        help = "A word to trace the evolution of. Can be provided multiple times to specify several words to trace."
    ).multiple()
    val intermediates by option(
        "-m", "--intermediates",
        help = "Use intermediate romanizers to dump intermediate forms of the words. " +
                "The resulting files have the romanizer names as suffixes."
    ).flag("-f", "--final-only", default = false)

    @ExperimentalTime
    override fun run() {
        SoundChanger.changeFiles(
            changes,
            words,
            startAt = startAt,
            stopBefore = stopBefore,
            inSuffix = inSuffix,
            outSuffix = outSuffix,
            debugWords = traceWords,
            intermediates = intermediates
        )
    }
}

fun main(args: Array<String>) = Lexurgy().subcommands(SC()).main(args)
