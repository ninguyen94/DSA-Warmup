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

fun orangesRotting(grid: Array<IntArray>): Int {
    val row = grid.size
    val col = grid[0].size
    val directions = arrayOf(
        intArrayOf(-1, 0), //up
        intArrayOf(1, 0),//down
        intArrayOf(0, -1),//left
        intArrayOf(0, 1)//right
    )


    //time count
    var time = 0
    val rottenQueue = ArrayDeque<Pair<Int, Int>>()
    val visited = Array(row) { BooleanArray(col) { false } }
    var freshCount = 0
    for (r in 0 until row) {
        for (c in 0 until col) {
            if (grid[r][c] == 2) {
                rottenQueue.add(r to c)
                visited[r][c] = true
            } else if (grid[r][c] == 1) {
                freshCount++
            }
        }
    }

    while (freshCount > 0 && rottenQueue.isNotEmpty()) {
        val levelRepeatTimes = rottenQueue.size

        repeat(levelRepeatTimes, {
            val current = rottenQueue.removeFirst()
            for (direction in directions) {
                //next row index
                val nr = current.first + direction[0]
                //next col index
                val nc = current.second + direction[1]

                //exit condition
                if (nr !in 0 until row || nc !in 0 until col || grid[nr][nc] == 0 || visited[nr][nc]) {
                    continue
                }

                //add to queue
                rottenQueue.add(nr to nc)
                visited[nr][nc] = true
                freshCount--
            }
        })

        time++
    }

    return if (freshCount > 0) -1 else time

}