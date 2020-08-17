package com.meamoria.lexurgy

import java.nio.file.Path
import java.nio.file.Paths

fun loadList(path: Path, suffix: String? = null): List<String> =
    suffixPath(path, suffix).toFile().readLines()

fun dumpList(path: Path, words: List<String>, suffix: String? = null): Unit =
    suffixPath(path, suffix).toFile().writeText((words + "").joinToString(System.lineSeparator()))

fun suffixPath(path: Path, suffix: String? = null): Path =
    if (suffix == null) path else
        with(path.toFile()) {
            val fname = nameWithoutExtension + "_" + suffix + "." + extension
            if (parent == null) Paths.get(fname)
            else Paths.get(parent, fname)
        }
