package com.meamoria.lexurgy

/**
 * An immutable prefix tree ("trie") designed to parse a word into segments
 */
class SegmentTree<T>(map: Map<String, T>) {

    private val root = Node()

    init {
        for ((segment, value) in map.entries) {
            var curtree = root
            for (char in segment) {
                curtree = curtree.children.setdefault(char, Node())
            }
            curtree.value = value
        }
    }

    override fun toString(): String = "SegmentTree" + root.subtreeString()

    private inner class Node {
        var value: T? = null
        val children = mutableMapOf<Char, Node>()

        fun subtreeString(): String {
            val valueBit = value?.toString()?.let {listOf(it)} ?: emptyList()
            val childrenBits = children.map {(char, sub) -> char + "->" + sub.subtreeString()}
            return (valueBit + childrenBits).joinToString(separator = ", ", prefix = "(", postfix = ")")
        }
    }
}