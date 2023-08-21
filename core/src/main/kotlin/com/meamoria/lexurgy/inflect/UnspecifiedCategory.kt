package com.meamoria.lexurgy.inflect

import com.meamoria.lexurgy.word.Word

class UnspecifiedCategory(
    val stem: Word,
    val categories: Set<String>,
    val missingCategoryOptions: Set<String>
) : InflectUserError(
    "Can't inflect word \"${stem.string}\" " +
            "into categories (${categories.joinToString()}); " +
            "expected one of (${missingCategoryOptions.joinToString()})"
)
