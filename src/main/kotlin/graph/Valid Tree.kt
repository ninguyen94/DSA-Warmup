package graph

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

fun validTree(n: Int, edges: Array<IntArray?>?): Boolean {
    val nodeMap = Array<MutableList<Int>>(n) { mutableListOf() }
    if (edges.isNullOrEmpty()) return true

    edges.forEach {
        nodeMap[it!![0]].add(it[1])
        nodeMap[it[1]].add(it[0])
    }

    val visited = BooleanArray(n)

    fun dfs(node: Int, parent: Int): Boolean {
        visited[node] = true

        nodeMap[node].forEach {
            if (!visited[it]) {
                if (dfs(it, node)) {
                    return true
                }
            } else if (it != parent) {
                return true
            }
        }

        return false
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            if (dfs(i, -1)) {
                return false
            }
        }
    }

    return true
}


