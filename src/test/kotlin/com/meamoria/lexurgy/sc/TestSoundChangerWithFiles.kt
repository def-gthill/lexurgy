package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.dumpList
import com.meamoria.lexurgy.loadList
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.nio.file.FileSystems
import java.nio.file.Path
import kotlin.time.ExperimentalTime

@ExperimentalTime
class TestSoundChangerWithFiles : StringSpec({
    fun pathOf(vararg pathComponents: String): Path =
        FileSystems.getDefault().getPath("test", *pathComponents)

    fun listFrom(vararg pathComponents: String): List<String> =
        loadList(pathOf(*pathComponents))

    fun listTo(words: List<String>, vararg pathComponents: String) =
        dumpList(pathOf(*pathComponents), words)

    val changer = SoundChanger.fromLscFile(pathOf("muipidan.lsc"))

    "A sound changer should be able to process some wordlists" {
        changer.changeFiles(listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")))
        listFrom("ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_expected.wli")
        listFrom("ptr_test_2_ev.wli") shouldBe listFrom("ptr_test_2_ev_expected.wli")
    }

    "The --compare-stages setting should print the original in the output" {
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")),
            compareStages = true
        )
        listFrom("ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_stages.wli")
        listFrom("ptr_test_2_ev.wli") shouldBe listFrom("ptr_test_2_ev_stages.wli")
    }

    "The --compare-versions setting should print the previous version in the output" {
        listTo(listFrom("ptr_test_1_ev_previous.wli"), "ptr_test_1_ev.wli")
        listTo(listFrom("ptr_test_2_ev_previous.wli"), "ptr_test_2_ev.wli")
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")),
            compareVersions = true
        )
        listFrom("ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_versions.wli")
        listFrom("ptr_test_2_ev.wli") shouldBe listFrom("ptr_test_2_ev_versions.wli")
    }

    "Compare versions and compare stages should work together" {
        listTo(listFrom("ptr_test_1_ev_previous.wli"), "ptr_test_1_ev.wli")
        listTo(listFrom("ptr_test_2_ev_previous.wli"), "ptr_test_2_ev.wli")
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")),
            compareStages = true,
            compareVersions = true
        )
        listFrom("ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_stages_versions.wli")
        listFrom("ptr_test_2_ev.wli") shouldBe listFrom("ptr_test_2_ev_stages_versions.wli")
    }

    "Compare versions should still work if the previous version had markup in it" {
        listTo(listFrom("ptr_test_1_ev_previous_with_markup.wli"), "ptr_test_1_ev.wli")
        listTo(listFrom("ptr_test_2_ev_previous_with_markup.wli"), "ptr_test_2_ev.wli")
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")),
            compareStages = true,
            compareVersions = true
        )
        listFrom("ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_stages_versions.wli")
        listFrom("ptr_test_2_ev.wli") shouldBe listFrom("ptr_test_2_ev_stages_versions.wli")
    }

    "Compare should correctly align the separators when the words contain IPA diacritics" {
        val dChanger = SoundChanger.fromLsc("add-d:\n* => d / _ $")
        dChanger.changeFiles(
            listOf(pathOf("test_robust_length.wli")),
            compareStages = true
        )
        listFrom("test_robust_length_ev.wli") shouldBe listFrom("test_robust_length_expected.wli")
    }
})