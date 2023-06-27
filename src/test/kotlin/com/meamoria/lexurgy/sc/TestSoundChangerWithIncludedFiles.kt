package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.dumpList
import com.meamoria.lexurgy.loadList
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.nio.file.FileSystems
import java.nio.file.Path
import kotlin.time.ExperimentalTime

@Suppress("unused")
@ExperimentalTime
class TestSoundChangerWithIncludedFiles : StringSpec({
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

    val changer = soundChangerFromLscFile(pathOf("muipidan_includer.lsc"))

    "A sound changer with included files should be able to process some wordlists" {
        val outDir = prepareOutDir("basic")
        changer.changeFiles(
            listOf(pathOf("ptr_test_1.wli"), pathOf("ptr_test_2.wli")),
            outDir = outDir,
        )
        listFrom(outDir, "ptr_test_1_ev.wli") shouldBe listFrom("ptr_test_1_ev_expected.wli")
        listFrom(outDir, "ptr_test_2_ev.wli") shouldBe listFrom("ptr_test_2_ev_expected.wli")
    }
})