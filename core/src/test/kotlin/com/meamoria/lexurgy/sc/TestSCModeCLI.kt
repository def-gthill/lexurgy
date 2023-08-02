package com.meamoria.lexurgy.sc

import com.github.ajalt.clikt.core.ProgramResult
import com.meamoria.lexurgy.lexurgyCommand
import com.meamoria.lexurgy.loadList
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.nio.file.FileSystems
import java.nio.file.Path
import kotlin.time.ExperimentalTime

@Suppress("unused")
@ExperimentalTime
class TestSCModeCLI : StringSpec({
    fun pathOf(vararg pathComponents: String): Path =
        FileSystems.getDefault().getPath("test", *pathComponents)

    fun listFrom(vararg pathComponents: String): List<String> =
        loadList(pathOf(*pathComponents))

    fun prepareOutDir(outDir: String): String {
        val outFolder = pathOf(outDir).toFile()
        outFolder.deleteRecursively()
        outFolder.mkdir()
        return outDir
    }

    "The CLI can do sound changes on a file" {
        val outDir = prepareOutDir("basic_cli")
        lexurgyCommand.parse(arrayOf("sc", "test/muipidan.lsc", "--out-dir", outDir, "test/ptr_test_1.wli"))
        listFrom(outDir, "ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_expected.wli")
    }

    "The CLI throws an error if a rule application fails" {
        shouldThrow<ProgramResult> {
            lexurgyCommand.parse(arrayOf("sc", "test/test_all_errors.lsc", "test/test_all_errors.wli"))
        }
    }

    "In all-errors mode, the CLI outputs successful results and all encountered errors" {
        val outDir = prepareOutDir("all_errors")
        lexurgyCommand.parse(
            arrayOf("sc", "--all-errors", "--out-dir", outDir, "test/test_all_errors.lsc", "test/test_all_errors.wli")
        )
        listFrom(outDir, "test_all_errors_ev.wli") shouldBe
                listFrom("test_all_errors_ev_expected.wli")
        listFrom(outDir, "test_all_errors_errors.wli") shouldBe
                listFrom("test_all_errors_errors_expected.wli")
    }

    "Intermediates and all-errors mode can be active at the same time" {
        val outDir = prepareOutDir("all_errors_intermediates")
        lexurgyCommand.parse(
            arrayOf("sc", "--intermediates", "--all-errors", "--out-dir", outDir) +
                    arrayOf("test/test_all_errors.lsc", "test/test_all_errors.wli")
        )
        listFrom(outDir, "test_all_errors_ev.wli") shouldBe
                listFrom("test_all_errors_ev_expected.wli")
        listFrom(outDir, "test_all_errors_inter.wli") shouldBe
                listFrom("test_all_errors_inter_expected.wli")
        listFrom(outDir, "test_all_errors_errors.wli") shouldBe
                listFrom("test_all_errors_errors_expected.wli")
    }

    "Tracing and all-errors mode can be active at the same time" {
        val outDir = prepareOutDir("all_errors_tracing")
        lexurgyCommand.parse(
            arrayOf("sc", "--all-errors", "-t", "bajhowh", "--out-dir", outDir) +
                    arrayOf("test/test_all_errors.lsc", "test/test_all_errors.wli")
        )
        listFrom(outDir, "test_all_errors_trace.wli") shouldBe
                listFrom("test_all_errors_trace_expected.wli")
    }
})
