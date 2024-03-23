package com.meamoria.lexurgy.sc

/**
 * Options for a sound change run.
 *
 * @param startAt If provided, ignore all rules before the one with the specified name
 * @param stopBefore If provided, ignore the rule with the specified name and all rules after it
 * @param debugWords Words to trace the evolution of
 * @param romanize True to run the romanizer (if any), false to ignore it
 * @param debug Function to call with tracing output
 * @param trace Function to call with structured tracing output
 * @param singleStepTimeoutSeconds Maximum allowed time in seconds to apply one rule to one word
 * @param totalTimeoutSeconds Maximum allowed time in seconds to complete the entire run
 */
data class SoundChangeOptions(
    val startAt: String? = null,
    val stopBefore: String? = null,
    val debugWords: List<String> = emptyList(),
    val romanize: Boolean = true,
    val debug: (String) -> Unit = ::println,
    val trace: (TraceInfo) -> Unit = { },
    val singleStepTimeoutSeconds: Double? = null,
    val totalTimeoutSeconds: Double? = null,
)
