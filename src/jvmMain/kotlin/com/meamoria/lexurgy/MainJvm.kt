package com.meamoria.lexurgy

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.ProgramResult
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.multiple
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.multiple
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.path
import com.meamoria.lexurgy.sc.LscRuleCrashed
import com.meamoria.lexurgy.sc.changeFiles
import com.meamoria.lexurgy.server.runServer
import java.io.IOException
import java.io.PrintWriter
import kotlin.time.ExperimentalTime

fun runErrorProne(developer: Boolean, block: () -> Unit) {
    try {
        block()
    } catch (e: Exception) {
        val writer = PrintWriter(ConsoleWriter)
        if (developer) {
            if (e is LscRuleCrashed) {
                console(e.message.toString())
                e.reason.printStackTrace(writer)
            } else {
                e.printStackTrace(writer)
            }
            writer.flush()
        } else {
            if (e is UserError || e is IOException) console(e.message.toString())
            else console(
                "Lexurgy couldn't apply the changes because of an unexpected error. " +
                        "Rerun with developer mode turned on (-d) and submit a bug report " +
                        "at https://github.com/def-gthill/lexurgy/issues with the output attached."
            )
        }
        throw ProgramResult(1)
    }
}

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
    val outDir by option(
        "--out-dir",
        help = "The directory in which to write output files, relative to the parent directory of the corresponding input file. " +
                "Defaults to \".\" (i.e. the same directory as the input file)."
    ).default(".")
    val traceWords by option(
        "-t", "--trace-word",
        help = "A word to trace the evolution of. Can be provided multiple times to specify several words to trace."
    ).multiple()
    val allErrors by option(
        "-e", "--all-errors",
        help = "Produce all successful outputs and all error messages (rather than crashing on the first error)."
    ).flag("-E", "--first-error", default = false)
    val intermediates by option(
        "-m", "--intermediates",
        help = "Use intermediate romanizers to dump intermediate forms of the words. " +
                "The resulting files have the romanizer names as suffixes."
    ).flag("-f", "--final-only", default = false)
    val romanize by option(
        "-r", "--romanize",
        help = "Romanize the output wordlists. If false, the raw phonetic forms are " +
                "written instead (and --compare-versions is automatically turned off)."
    ).flag("-p", "--phonetic", default = true)
    val compareStages by option(
        "-s", "--compare-stages",
        help = "Print the original form of the word (and any intermediates if -m is enabled) " +
                "alongside the evolved form in .wlm files parallel to the output files."
    ).flag("-S", "--no-compare-stages", default = true)
    val compareVersions by option(
        "-v", "--compare-versions",
        help = "Compare the output files to the existing versions of the same files, " +
                "flagging any changes in .wlm files. Useful if you're tweaking the .lsc file and " +
                "want to make sure your changes don't have unintended consequences."
    ).flag("-V", "--no-compare-versions", default = false)
    val developer by option(
        "-d", "--developer",
        help = "Write the full trace when Lexurgy encounters a fatal error. " +
                "Use this if you want to submit a bug report."
    ).flag("-u", "--user", default = false)

    @ExperimentalTime
    override fun run() {
        runErrorProne(developer) {
            changeFiles(
                changes,
                words,
                startAt = startAt,
                stopBefore = stopBefore,
                inSuffix = inSuffix,
                outSuffix = outSuffix,
                outDir = outDir,
                debugWords = traceWords,
                allErrors = allErrors,
                intermediates = intermediates,
                romanize = romanize,
                compareStages = compareStages,
                compareVersions = compareVersions && romanize
            )
        }
    }
}

class Server : CliktCommand(
    help = "Applies sound changes from CHANGES (a .lsc file) to the words in stdin and outputs to stdout."
) {
    val changes by argument().path(mustBeReadable = true)

    @ExperimentalTime
    override fun run() {
        runErrorProne(true) {
            runServer(changes)
        }
    }
}

val lexurgyCommand = Lexurgy().subcommands(SC(), Server())

fun main(args: Array<String>) {
    val realArgs = getArgs(args)
    lexurgyCommand.main(realArgs)
}
