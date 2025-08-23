package graph

import kotlin.math.max
import kotlin.math.min

/**
You are given a rectangular island heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The islands borders the Pacific Ocean from the top and left sides, and borders the Atlantic Ocean from the bottom and right sides.

Water can flow in four directions (up, down, left, or right) from a cell to a neighboring cell with height equal or lower. Water can also flow into the ocean from cells adjacent to the ocean.

Find all cells where water can flow from that cell to both the Pacific and Atlantic oceans. Return it as a 2D list where each element is a list [r, c] representing the row and column of the cell. You may return the answer in any order.


 */
fun main() {
    val res = pacificAtlantic(
        arrayOf(
            intArrayOf(1,2,2,3,5),
            intArrayOf(3,2,3,4,4),
            intArrayOf(2,4,5,3,1),
            intArrayOf(6,7,1,4,5),
            intArrayOf(5,1,1,2,4)
            )
    )
    println(res)
}

fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    val row = heights.size
    val col = heights[0].size
    val pacific = Array(row) { BooleanArray(col) { false } }
    val atlantic = Array(row) { BooleanArray(col) { false } }
    val pacificList = mutableListOf<Pair<Int, Int>>()
    val atlanticList = mutableListOf<Pair<Int, Int>>()

    val directions = arrayOf(
        intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1)
    )

    for (r in 0 until row) {
        pacificList.add(r to 0)
        atlanticList.add(r to col - 1)
    }

    for (c in 0 until col) {
        pacificList.add(0 to c)
        atlanticList.add(row - 1 to c)
    }

    fun bfs(source: List<Pair<Int, Int>>, visited: Array<BooleanArray>) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addAll(source)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            val r = current.first
            val c = current.second
            visited[r][c] = true
            for (direction in directions) {
                val nr = r + direction[0]
                val nc = c + direction[1]
                if (nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc] || heights[r][c] > heights[nr][nc]) {
                    continue
                }
                queue.add(nr to nc)
            }
        }
    }

    bfs(pacificList, pacific)
    bfs(atlanticList, atlantic)

    val res = mutableListOf<List<Int>>()
    for (r in 0 until row) {
        for (c in 0 until col) {
            if (pacific[r][c] && atlantic[r][c]) {
                res.add(listOf(r, c))
            }
        }
    }

    return res
}