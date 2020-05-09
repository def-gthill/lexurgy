package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.PhoneticSegment
import com.meamoria.lexurgy.PhoneticWord
import com.meamoria.lexurgy.PlainSegment
import com.meamoria.lexurgy.Word

class Declarations {
    fun parsePhonetic(text: String): Word<PhoneticSegment> =
        PhoneticWord(text.chunked(1))
//         phoneticParser.parse(text)

    fun parsePhonetic(word: Word<PlainSegment>): Word<PhoneticSegment> = parsePhonetic(word.string)
}

class Matrix
