package graph

import kotlin.math.max

/**
684. Redundant Connection
https://leetcode.com/problems/redundant-connection/
 */
fun main() {
//    val res = orangesRotting(
//        arrayOf(
//            intArrayOf(2, 1, 1),
//            intArrayOf(1, 1, 0),
//            intArrayOf(0, 1, 1),
//            intArrayOf(0, -1, 2147483647, 2147483647),
//        )
//    )
//    println(intArrayOf(1,2,3,1,1,2,3).distinct())
}

fun findRedundantConnection(edges: Array<IntArray>): IntArray {
    val nodeMap = Array<MutableList<Int>>(edges.size + 1) { mutableListOf() }


    fun dfs(node: Int, parent: Int, visited: BooleanArray): Boolean {
        if (visited[node]) return true
        visited[node] = true

        for (nei in nodeMap[node]) {
            if (nei == parent) continue
            if (dfs(nei, node, visited)) return true
        }
        return false
    }


    for ((u, v) in edges) {
        nodeMap[u].add(v)
        nodeMap[v].add(u)
        val visited = BooleanArray(edges.size + 1)

        if (dfs(u, -1, visited)) {
            return intArrayOf(u, v)
        }

    }

    return intArrayOf()
}




