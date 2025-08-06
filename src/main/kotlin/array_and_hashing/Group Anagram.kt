package array_and_hashing

/*+
Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 */

fun main() {
    val result = groupAnagrams(arrayOf("bdddddddddd", "bbbbbbbbbbc"))
    println(result.joinToString())
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val charCountMap = mutableMapOf<String, MutableList<String>>()
    strs.forEach { str ->
        val charCount = IntArray(26)

        str.forEach { c ->
            charCount[c - 'a']++
        }
        val charCountString = charCount.joinToString(",")

        charCountMap.getOrPut(charCountString) { mutableListOf() }.add(str)
    }

    return charCountMap.values.toList()
}