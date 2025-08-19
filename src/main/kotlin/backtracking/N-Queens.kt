package backtracking

import kotlin.collections.get
import kotlin.collections.set
import kotlin.compareTo

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
fun main() {
    val res = solveNQueens(4)
    println(res.toString())
}


fun solveNQueens(n: Int): List<List<String>> {
    val chessboardMap = Array(n) { CharArray(n) { '.' } }
    val res = mutableListOf<List<String>>()

    fun isSafe(r: Int, c: Int): Boolean {
        var row = r - 1
        while (row >= 0) {
            if (chessboardMap[row][c] == 'Q') return false
            row--
        }
        var col = c - 1
        row = r - 1
        while (row >= 0 && col >= 0) {
            if (chessboardMap[row][col] == 'Q') return false
            row--
            col--
        }
        col = c + 1
        row = r - 1
        while (row >= 0 && col < n) {
            if (chessboardMap[row][col] == 'Q') return false
            row--
            col++
        }
        return true
    }

    fun traversalBoard(rowIdx: Int) {
        if (rowIdx == n) {
            res.add(chessboardMap.map { it.joinToString("") })
            return
        }
        for (colIdx in 0 until n) {
            if (isSafe(rowIdx, colIdx)) {
                chessboardMap[rowIdx][colIdx] = 'Q'
                traversalBoard(rowIdx + 1)
                chessboardMap[rowIdx][colIdx] = '.'
            }
        }
    }

    traversalBoard(0)
    return res
}
