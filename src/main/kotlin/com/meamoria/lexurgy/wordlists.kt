package com.meamoria.lexurgy

import java.io.File

fun loadList(pathName: String): List<String> = File(pathName).readLines()