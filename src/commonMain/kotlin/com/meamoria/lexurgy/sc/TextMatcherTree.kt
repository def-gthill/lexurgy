package com.meamoria.lexurgy.sc

import com.meamoria.lexurgy.Segment
import com.meamoria.lexurgy.Word

class TextMatcherTree(val declarations: Declarations, elements: List<AbstractTextMatcher>) {
    private val root = Node()

    init {
        for ((i, matcher) in elements.withIndex()) {
            var curtree = root
            with (declarations) {
                for (segment in matcher.text) {
                    curtree = curtree.children.getOrPut(
                        segment.withoutFloatingDiacritics(), ::Node
                    )
                }
            }
            curtree.indices += i
        }
    }

    /**
     * Try to match elements to a slice of the specified word,
     * starting at the specified start position. Returns a
     * list of the indices of the matching elements, sorted
     * from smallest to largest.
     */
    fun tryMatch(word: Word, start: Int): List<Int> {
        var cur = start
        var curtree = root
        val result = mutableListOf<Int>()
        with (declarations) {
            while (cur < word.length) {
                val segment = word[cur].withoutFloatingDiacritics()
                curtree.children[segment]?.let { child ->
                    result += child.indices
                    curtree = child
                    cur++
                } ?: break
            }
        }

        return result.sorted()
    }

    override fun toString(): String = "SegmentTree" + root.subtreeString()

    private inner class Node {
        val indices: MutableList<Int> = mutableListOf()
        val children = mutableMapOf<Segment, Node>()

        fun subtreeString(): String {
            val valueBit = listOf(indices)
            val childrenBits = children.map {(segment, sub) -> segment.string + "->" + sub.subtreeString()}
            return (valueBit + childrenBits).joinToString(separator = ", ", prefix = "(", postfix = ")")
        }
    }
}