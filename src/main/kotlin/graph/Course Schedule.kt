package graph

import java.util.LinkedList
import java.util.Queue
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

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val courseList = Array<MutableList<Int>>(numCourses) { mutableListOf() }

    //mapping to course list
    prerequisites.forEach {
        courseList[it[0]].add(it[1])
    }

    val visited = BooleanArray(numCourses) { false }
    val inPath = BooleanArray(numCourses) { false }

    fun dfs(node: Int): Boolean {
        if (inPath[node]) return true
        if (visited[node]) return false

        visited[node] = true
        inPath[node] = true

        for (nei in courseList[node]) {
            if (dfs(nei)) return true
        }

        inPath[node] = false
        return false
    }

    for (i in 0 until numCourses) {
        if (dfs(i)) return false
    }

    return true
}


