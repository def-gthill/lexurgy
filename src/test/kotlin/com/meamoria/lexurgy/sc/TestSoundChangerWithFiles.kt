package com.meamoria.lexurgy.sc

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
})