@file:JsModule("xregexp")
@file:JsNonModule

package com.meamoria.mpp.xregexp

import kotlin.js.RegExp

external fun test(str: String, regex: RegExp): Boolean
