package backtracking

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
fun main() {
    val res = letterCombinations("23")
    println(res.toString())
}

fun letterCombinations(digits: String): List<String> {
    if (digits.isBlank()) return listOf()
    val map = arrayOf(
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    )
    val res = mutableListOf<String>()
    val currentString = StringBuilder()

    fun dfs(keyIdx: Int) {
        if (keyIdx > digits.length) {
            return
        }

        if (currentString.length == digits.length) {
            res.add(currentString.toString())
            return
        }
        map[digits[keyIdx] - '0'].forEach { ch ->
            currentString.append(ch)
            dfs(keyIdx + 1)
            currentString.deleteCharAt(currentString.length - 1)
        }
    }

    dfs(0)

    return res
}
