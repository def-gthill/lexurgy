package com.meamoria.lexurgy.cli

import com.meamoria.lexurgy.LscUserError
import java.nio.file.Path


class CircularInclusion(path: Path) : LscUserError(
    "File ${path.fileName} has a circular inclusion"
)

class SoundChangesFileLoader {
    companion object {
        val INCLUDE_LINE = Regex("^\\s*#include\\s+\"(.+?)\"\\s*$")
    }

    fun load(path: Path, pathsVisited: Set<Path> = setOf()): Sequence<String> {
        if (path in pathsVisited) {
            throw CircularInclusion(path)
        }
        val nextPathsVisited = pathsVisited + setOf(path)

        return sequence {
            for (line in path.toFile().readLines()) {
                val match = INCLUDE_LINE.find(line)
                if (match == null) {
                    yield(line)
                    continue
                }
                val includedPath = match.groupValues[1]
                yieldAll(load(
                    path.toAbsolutePath().parent.resolve(includedPath),
                    nextPathsVisited
                ))
            }
        }
    }
}