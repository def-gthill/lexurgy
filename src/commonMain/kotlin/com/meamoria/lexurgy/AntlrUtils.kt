package com.meamoria.lexurgy

import com.meamoria.mpp.antlr.ParserRuleContext
import com.meamoria.mpp.antlr.children
import com.meamoria.mpp.antlr.getParentContext
import kotlin.reflect.KClass
import kotlin.reflect.safeCast


inline fun <reified T : ParserRuleContext> ParserRuleContext?.upToType(): T? =
    this?.upToType(T::class)

fun <T : ParserRuleContext> ParserRuleContext.upToType(cls: KClass<T>): T? {
    var context: ParserRuleContext? = this
    while (context != null) {
        cls.safeCast(context)?.let { return it }
        context = context.getParentContext() as ParserRuleContext?
    }
    return null
}

inline fun <reified T : ParserRuleContext> ParserRuleContext?.upToType(fn: (T) -> String?): String? =
    upToType<T>()?.let(fn)

inline fun <reified T : ParserRuleContext> ParserRuleContext?.downToType(): T? =
    this?.downToType(T::class)

fun <T : ParserRuleContext> ParserRuleContext.downToType(cls: KClass<T>): T? {
    cls.safeCast(this)?.let { return it }
    for (child in this.children) {
        if (child is ParserRuleContext) {
            child.downToType(cls)?.let { return it }
        }
    }
    return null
}

inline fun <reified T : ParserRuleContext> ParserRuleContext?.downToType(fn: (T) -> String?): String? =
    downToType<T>()?.let(fn)