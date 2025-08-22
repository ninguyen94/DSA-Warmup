package graph

import kotlin.math.max

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 */
fun main() {
    val res = numIslands(
        arrayOf(
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '0', '1', '0', '1'),
            charArrayOf('1', '1', '1', '0', '1'),
        )
    )
    println(res)
}

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var max = 0
    var count = 0
    val row = grid.size
    val col = grid[0].size
    fun dfs(r: Int, c: Int) {
        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == 0) {
            return
        }
        grid[r][c] = 0
        count++
        //up
        dfs(r - 1, c)
        //down
        dfs(r + 1, c)
        //right
        dfs(r, c + 1)
        //right
        dfs(r, c - 1)
    }


    for (r in 0 until row) {
        for (c in 0 until col) {
            if (grid[r][c] == 1) {
                count = 0
                dfs(r, c)
                max = max(max, count)
            }
        }
    }
    return max
}