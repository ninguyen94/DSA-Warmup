package backtracking

import kotlin.math.ceil
import kotlin.math.min

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
fun main() {
    val res = partition("cdd")
    println(res.toString())
}

fun partition(s: String): List<List<String>> {
    val res = mutableListOf<List<String>>()
    val subStringList = mutableListOf<String>()
    fun dfs(idx: Int, subStringIdx: Int) {
        if (idx == s.length) {
            if (idx == subStringIdx) {
                res.add(subStringList.toList())
            }
            return
        }

        if (isPalindrome(s, subStringIdx, idx)) {
            subStringList.add(s.substring(subStringIdx, idx + 1))
            dfs(idx + 1, idx + 1)
            subStringList.removeLast()
        }

        dfs(idx + 1, subStringIdx)
    }
    dfs(0, 0)
    return res
}

fun isPalindrome(string: String, start: Int, end: Int): Boolean {
    var r = start
    var l = end

    while (r < l) {
        if (string[r] == string[l]) {
            r++
            l--
        } else return false
    }

    return true
}
