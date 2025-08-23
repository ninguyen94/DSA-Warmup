package graph

import kotlin.math.max
import kotlin.math.min

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 */
fun main() {
    val res = islandsAndTreasure(
        arrayOf(
            intArrayOf(2147483647, -1, -1, 2147483647),
            intArrayOf(2147483647, 2147483647, 2147483647, -1),
            intArrayOf(2147483647, -1, 2147483647, -1),
            intArrayOf(0, -1, 2147483647, 2147483647),
        )
    )
}

fun islandsAndTreasure(grid: Array<IntArray?>?) {
    val INF = 2147483647
    val row = grid!!.size
    val col = grid[0]!!.size
    val res = Array(row) { IntArray(col) }
    val visited = mutableSetOf<Pair<Int, Int>>()

    fun dfs(r: Int, c: Int): Int {
        if (r < 0 || c < 0 || r >= row || c >= col || grid[r]!![c] == -1 || visited.contains(r to c)) {
            return -1
        }
        if (grid[r]!![c] == 0) return 0
        visited.add(r to c)
        //up
        var up = dfs(r - 1, c)
        up = if (up < 0) INF else up

        var down = dfs(r + 1, c)
        down = if (down < 0) INF else down

        var left = dfs(r, c - 1)
        left = if (left < 0) INF else left

        var right = dfs(r, c + 1)
        right = if (right < 0) INF else right

        val path = minOf(up, down, right, left)
        visited.remove(r to c)
        return if (path == INF) INF else path + 1
    }
    for (r in 0 until row) {
        for (c in 0 until col) {
            res[r][c] = dfs(r, c)
        }
    }
    println(res.joinToString())
}