package com.meamoria.lexurgy.cli

import com.meamoria.lexurgy.sc.SoundChanger
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.nio.file.FileSystems
import java.nio.file.Path
import kotlin.time.ExperimentalTime

@Suppress("unused")
@ExperimentalTime
class TestSoundChangerWithFiles : StringSpec({
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

    val changer = soundChangerFromLscFile(pathOf("muipidan.lsc"))

    "A sound changer should be able to process some wordlists" {
        val outDir = prepareOutDir("basic")
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")),
            outDir = outDir,
        )
        listFrom(outDir, "ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_expected.wli")
        listFrom(outDir, "ptr_test_2_ev.wli") shouldBe listFrom("ptr_test_2_ev_expected.wli")
    }

    "A sound changer should be able to trace" {
        val outDir = prepareOutDir("trace")
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli")), debugWords=listOf("cukucaku"),
            outDir = outDir,
        )
        listFrom(outDir, "ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_expected.wli")
        listFrom(outDir, "ptr_test_1_trace.wli") shouldBe listFrom("ptr_test_1_trace_expected.wli")
    }

    "A sound changer should be able to trace syllables" {
        val outDir = prepareOutDir("trace_syllables")
        val syllabianChanger =  soundChangerFromLscFile(pathOf("syllabian.lsc"))
        syllabianChanger.changeFiles(
            listOf(pathOf("proto-syllabian.wli")),
            outDir = outDir,
            debugWords=listOf("karapuna"),
        )
        listFrom(outDir, "proto-syllabian_trace.wli") shouldBe
                listFrom("proto-syllabian_trace_expected.wli")
    }

    "A sound changer should be able to trace many words" {
        val outDir = prepareOutDir("trace_many")
        val syllabianChanger =  soundChangerFromLscFile(pathOf("syllabian.lsc"))
        syllabianChanger.changeFiles(
            listOf(pathOf("proto-syllabian.wli")),
            outDir = outDir,
            debugWords=listOf("karapuna", "pana"),
        )
        listFrom(outDir, "proto-syllabian_trace.wli") shouldBe
                listFrom("proto-syllabian_trace_many_expected.wli")
    }

    "A sound changer should not produce a trace file when not tracing" {
        val outDir = prepareOutDir("no_trace")
        val syllabianChanger = soundChangerFromLscFile(pathOf("syllabian.lsc"))

        syllabianChanger.changeFiles(
            listOf(pathOf("proto-syllabian.wli")),
            outDir = outDir,
        )

        pathOf(outDir, "proto-syllabian_trace.wli").toFile().exists() shouldBe false
    }

    "The --compare-stages setting should print the original in a wlm file" {
        val outDir = prepareOutDir("compare_stages")
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")),
            outDir = outDir,
            compareStages = true,
        )
        listFrom(outDir, "ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_expected.wli")
        listFrom(outDir, "ptr_test_1_ev.wlm") shouldBe listFrom("ptr_test_1_ev_stages.wlm")
        listFrom(outDir, "ptr_test_2_ev.wli") shouldBe listFrom("ptr_test_2_ev_expected.wli")
        listFrom(outDir, "ptr_test_2_ev.wlm") shouldBe listFrom("ptr_test_2_ev_stages.wlm")
    }

    "The --compare-versions setting should print the previous version in the output" {
        val outDir = prepareOutDir("compare_versions")
        listTo(listFrom("ptr_test_1_ev_previous.wli"), outDir, "ptr_test_1_ev.wli")
        listTo(listFrom("ptr_test_2_ev_previous.wli"), outDir, "ptr_test_2_ev.wli")
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")),
            outDir = outDir,
            compareVersions = true,
        )
        listFrom(outDir, "ptr_test_1_ev.wlm") shouldBe listFrom("ptr_test_1_ev_versions.wlm")
        listFrom(outDir, "ptr_test_2_ev.wlm") shouldBe listFrom("ptr_test_2_ev_versions.wlm")

        shouldThrow<LscFileNotFound> {
            changer.changeFiles(
                listOf(pathOf("ptr_test_1.wli")),
                outDir = outDir,
                outSuffix = "dne",
                compareVersions = true,
            )
        }.also {
            it.message shouldBe "Can't compare output words to ptr_test_1_dne.wli; the file doesn't exist"
        }
    }

    "Compare versions and compare stages should work together" {
        val outDir = prepareOutDir("compare_versions_and_stages")
        listTo(listFrom("ptr_test_1_ev_previous.wli"), outDir, "ptr_test_1_ev.wli")
        listTo(listFrom("ptr_test_2_ev_previous.wli"), outDir, "ptr_test_2_ev.wli")
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")),
            outDir = outDir,
            compareStages = true,
            compareVersions = true,
        )
        listFrom(outDir, "ptr_test_1_ev.wlm") shouldBe listFrom("ptr_test_1_ev_stages_versions.wlm")
        listFrom(outDir, "ptr_test_2_ev.wlm") shouldBe listFrom("ptr_test_2_ev_stages_versions.wlm")
    }

    "Compare should correctly align the separators when the words contain IPA diacritics" {
        val outDir = prepareOutDir("diacritic_alignment")
        val dChanger = SoundChanger.fromLsc("add-d:\n* => d / _ $")
        dChanger.changeFiles(
            listOf(pathOf("test_robust_length.wli")),
            outDir = outDir,
            compareStages = true,
        )
        listFrom(outDir, "test_robust_length_ev.wlm") shouldBe
                listFrom("test_robust_length_expected.wlm")
    }

    "This sample list of Three Rivers words should evolve into Muipidan words how they did in the old sound changer" {
        val expected = listOf(
            "hullïdo",
            "opayto",
            "ok'oyto",
            "hmallede",
            "hmuhlïdo",
            "hugo",
            "hukhïgo",
            "hube",
            "huphïbe",
            "su",
            "im",
            "osayto",
            "un",
            "kaf",
            "klo",
            "kmuhlue",
            "kaslahn",
            "k'esas"
        )

        val words = listFrom("ptr_test.wli")
        changer.change(words) shouldBe expected
    }
})