package com.meamoria.lexurgy.sc.parser

/**
 * The surroundings of an `Element` AST node within its
 * expression
 */
internal data class ElementContext(
    val section: RuleSection,
    val isAtStartOfSection: Boolean,
    val isAtEndOfSection: Boolean,
) {
    val isAtEdgeOfEnvironment: Boolean
        get() =
            section == RuleSection.ENVIRON &&
                    (isAtStartOfSection || isAtEndOfSection)

    fun butBetween(
        precedingElement: Element?,
        followingElement: Element?,
    ): ElementContext {
        return ElementContext(
            this.section,
            isAtStartOfSection = (precedingElement == null && this.isAtStartOfSection),
            isAtEndOfSection = (followingElement == null && this.isAtEndOfSection),
        )
    }

    companion object {
        fun aloneInMain(): ElementContext =
            ElementContext(RuleSection.MAIN, isAtStartOfSection = true, isAtEndOfSection = true)

        fun rightBeforeAnchor(): ElementContext =
            ElementContext(RuleSection.ENVIRON, isAtStartOfSection = true, isAtEndOfSection = false)

        fun rightAfterAnchor(): ElementContext =
            ElementContext(RuleSection.ENVIRON, isAtStartOfSection = false, isAtEndOfSection = true)
    }
}

internal enum class RuleSection {
    MAIN,
    ENVIRON,
}
