package backtracking

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
fun main() {
    val res = exist(
        arrayOf(
            charArrayOf('A', 'B', 'C', 'E'), charArrayOf('S', 'F', 'C', 'S'), charArrayOf('A', 'D', 'E', 'E')
        ), "ABCCED"
    )
    println(res.toString())
}

fun exist(board: Array<CharArray>, word: String): Boolean {
    val visited = mutableSetOf<Pair<Int, Int>>()
    val rowLength = board.size
    val colLength = board[0].size
    fun traversal(r: Int, c: Int, charIdx: Int): Boolean {
        if (charIdx == word.length) return true

        if (r < 0 || c < 0 || r >= rowLength || c >= colLength || board[r][c] != word[charIdx] || visited.contains(
                r to c
            )
        ) {
            return false
        }
        visited.add(r to c)
        val result = traversal(r + 1, c, charIdx + 1) || traversal(r - 1, c, charIdx + 1) || traversal(
            r, c + 1, charIdx + 1
        ) || traversal(r, c - 1, charIdx + 1)
        if (result) return true
        visited.remove(r to c)
        return false
    }

    for (r in 0 until rowLength) {
        for (c in 0 until colLength) {
            if (board[r][c] == word[0] && traversal(r, c, 0)) {
                return true
            }
        }
    }

    return false
}
