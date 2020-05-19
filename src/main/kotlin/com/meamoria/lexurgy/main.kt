package com.meamoria.lexurgy

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands

class Ling : CliktCommand() {
    override fun run() = Unit
}

class SC : CliktCommand(help="Applies sound changes from CHANGES (a .lsc file) to the words in WORDS (a .wli file)") {
    override fun run() {
        echo("Called sc")
    }
}

fun main(args: Array<String>) = Ling().subcommands(SC()).main(args)
