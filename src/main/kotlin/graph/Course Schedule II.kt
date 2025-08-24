package graph

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max
import kotlin.math.min

/**
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
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

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val courseMap = Array<MutableList<Int>>(numCourses) { mutableListOf() }
    val res = mutableListOf<Int>()
    val queue = ArrayDeque<Int>()
    val inDegree = Array(numCourses) { 0 }
    var visited = 0
    prerequisites.forEach {
        courseMap[it[1]].add(it[0])
        inDegree[it[0]]++
    }

    for ((idx,value) in inDegree.withIndex()) {
        if (value == 0) {
            queue.add(idx)
        }
    }

    while (queue.isNotEmpty()) {
        val topPriority = queue.removeFirst()
        visited++
        res.add(topPriority)
        courseMap[topPriority].forEach {
            inDegree[it]--
            if (inDegree[it] == 0) {
                queue.add(it)
            }
        }
    }

    return if (visited == numCourses) res.toIntArray() else intArrayOf()

}


