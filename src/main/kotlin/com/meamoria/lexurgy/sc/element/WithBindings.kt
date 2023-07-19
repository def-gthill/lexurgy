package com.meamoria.lexurgy.sc.element

import com.meamoria.lexurgy.sc.Bindings

interface WithBindings<T : WithBindings<T>> {
    fun replaceBindings(bindings: Bindings): T

    fun updateBindings(bindings: Bindings): T
}