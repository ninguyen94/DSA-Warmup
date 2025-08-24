package graph

import kotlin.math.max
import kotlin.math.min

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 */
fun main() {
    val res = orangesRotting(
        arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 1),
//            intArrayOf(0, -1, 2147483647, 2147483647),
        )
    )
    println(res)
}

fun solve(board: Array<CharArray>): Unit {
    val row = board.size
    val col = board[0].size


    val unSurroundCell = ArrayDeque<Pair<Int, Int>>()
    val visited = Array(row) { BooleanArray(col) { false } }
    val directions = arrayOf(
        intArrayOf(-1, 0),//up
        intArrayOf(1, 0),//down
        intArrayOf(0, -1),//left
        intArrayOf(0, 1),//right
    )

    for (r in 0 until row) {
        if (board[r][0] == 'O') {
            unSurroundCell.add(r to 0)
        }
        if (board[r][col - 1] == 'O') {
            unSurroundCell.add(r to col - 1)
        }
    }

    for (c in 0 until col) {
        if (board[0][c] == 'O') {
            unSurroundCell.add(0 to c)
        }

        if (board[row - 1][c] == 'O') {
            unSurroundCell.add(row - 1 to c)
        }
    }

    //bfs
    while (unSurroundCell.isNotEmpty()) {
        val currentPosition = unSurroundCell.removeFirst()
        val r = currentPosition.first
        val c = currentPosition.second
        visited[r][c] = true
        for (direction in directions) {
            val nr = r + direction[0]
            val nc = c + direction[1]

            //exit condition
            if (nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc] || board[nr][nc] != 'O') {
                continue
            }

            //add will traversal cell
            unSurroundCell.add(nr to nc)
        }
    }

    for (r in 0 until row) {
        for (c in 0 until col) {
            if (board[r][c] == 'O' && !visited[r][c]) {
                board[r][c] = 'X'
            }
        }
    }

}