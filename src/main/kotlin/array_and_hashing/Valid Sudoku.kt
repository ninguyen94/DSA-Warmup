package array_and_hashing

import kotlin.math.max
import kotlin.math.min

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */


/**
 * Learning : 2D -> 1D flattening
 * BitMask
 */

fun main() {
//    val result = isValidSudoku(arrayOf(charArrayOf("1","2",".",".","3",".",".",".","."))
//    println(result)
}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rowMap = IntArray(9)
    val colMap = IntArray(9)
    val squareMap = IntArray(9)
    for (rowIndex in 0..8) {
        for (colIndex in 0..8) {
            if (board[rowIndex][colIndex] == '.') continue

            val value = board[rowIndex][colIndex] - '1'
            val bit = 1 shl value
            val squareIndex = (rowIndex / 3) * 3 + (colIndex / 3)
            if (rowMap[rowIndex] and bit != 0 || colMap[colIndex] and bit != 0 || squareMap[squareIndex] and bit != 0) {
                return false
            }

            rowMap[rowIndex] = rowMap[rowIndex] or bit
            colMap[colIndex] = colMap[colIndex] or bit
            squareMap[squareIndex] = squareMap[squareIndex] or bit
        }
    }

    return true
}
