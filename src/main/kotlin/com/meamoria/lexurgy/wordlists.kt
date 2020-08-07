package com.meamoria.lexurgy

import java.nio.file.Path
import java.nio.file.Paths

fun loadList(path: Path, suffix: String? = null, removeMarkup: Boolean = false): List<String> {
    val contents = suffixPath(path, suffix).toFile().readLines()
    return if (removeMarkup)
        contents.map { it.split(" => ").last().split(" XX ").first().trim() }
    else contents
}

fun dumpList(path: Path, words: List<String>, suffix: String? = null): Unit =
    suffixPath(path, suffix).toFile().writeText((words + "").joinToString(System.lineSeparator()))

fun suffixPath(path: Path, suffix: String? = null): Path =
    if (suffix == null) path else
        with(path.toFile()) {
            Paths.get(parent, nameWithoutExtension + "_" + suffix + "." + extension)
        }
