package com.meamoria.lexurgy.sc

data class RuleWithAnchoredSteps(
    val rule: NamedRule?,
    val anchoredSteps: List<AnchoredStep>,
)

sealed interface AnchoredStep

data class IntermediateRomanizerStep(val romanizer: NamedRule) : AnchoredStep

data class CleanupStep(val cleanupRule: NamedRule) : AnchoredStep

data class CleanupOffStep(val ruleName: String) : AnchoredStep

data class SyllabificationStep(val declarations: Declarations) : AnchoredStep