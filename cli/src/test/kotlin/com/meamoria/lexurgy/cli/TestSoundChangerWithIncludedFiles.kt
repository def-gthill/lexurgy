package com.meamoria.lexurgy.cli

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.File
import java.io.FileInputStream
import java.nio.file.FileSystems
import java.nio.file.Path
import kotlin.time.ExperimentalTime

@Suppress("unused")
@ExperimentalTime
class TestSoundChangerWithIncludedFiles : StringSpec({
    fun String.toPath(): Path {
        return FileSystems.getDefault().getPath(this)
    }

    fun pathOf(vararg pathComponents: String): Path =
        FileSystems.getDefault().getPath("test", *pathComponents)

    fun listFrom(vararg pathComponents: String): List<String> =
        loadList(pathOf(*pathComponents))

    fun listTo(words: List<String>, vararg pathComponents: String) =
        dumpList(pathOf(*pathComponents), words)

    fun prepareOutDir(outDir: String): String {
        val outFolder = pathOf(outDir).toFile()
        outFolder.deleteRecursively()
        outFolder.mkdir()
        return outDir
    }

    fun copyToCwd(filenames: List<String>) {
        for (filename in filenames) {
            val sourcePath = pathOf(filename)
            val targetFile = File(filename)

            FileInputStream(sourcePath.toFile()).use { inputStream ->
                targetFile.outputStream().use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        }
    }

    fun deleteFromCwd(filenames: List<String>) {
        for (filename in filenames) {
            File(filename).delete()
        }
    }

    "A sound changer with included files should be able to process some wordlists" {
        val changer = soundChangerFromLscFile(pathOf("muipidan_includer.lsc"))
        val outDir = prepareOutDir("basic")
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")),
            outDir = outDir,
        )
        listFrom(outDir, "ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_expected.wli")
        listFrom(outDir, "ptr_test_2_ev.wli") shouldBe listFrom("ptr_test_2_ev_expected.wli")
    }

    "A sound changer can include a file in the same directory as the main file using just the filename" {
        val changer = soundChangerFromLscFile(pathOf("muipidan_includer_relative.lsc"))
        val outDir = prepareOutDir("basic")
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")),
            outDir = outDir,
        )
        listFrom(outDir, "ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_expected.wli")
        listFrom(outDir, "ptr_test_2_ev.wli") shouldBe listFrom("ptr_test_2_ev_expected.wli")
    }

    "A sound changer can include a file when the change file path is just a filename" {
        val filenames = listOf(
            "muipidan_includer_relative.lsc",
            "muipidan_included.lsc",
            "muipidan_definitions.lsc",
            "ptr_test_1.wli"
        )
        copyToCwd(filenames)

        try {
            val changer = soundChangerFromLscFile(
                "muipidan_includer_relative.lsc".toPath()
            )
            changer.changeFiles(listOf("ptr_test_1.wli".toPath()))
            loadList("ptr_test_1_ev.wli".toPath()) shouldBe listFrom("ptr_test_1_ev_expected.wli")
        } finally {
            deleteFromCwd(filenames + "ptr_test_1_ev.wli")
        }
    }
})