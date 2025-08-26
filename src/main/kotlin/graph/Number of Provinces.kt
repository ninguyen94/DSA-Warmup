package graph

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
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

//With DFS
fun findCircleNum(isConnected: Array<IntArray>): Int {
    val n = isConnected.size

    val nodeMap = Array<MutableList<Int>>(n) { mutableListOf() }

    //mapping to nodeMap
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == j) continue
            if (isConnected[i][j] == 1) {
                nodeMap[i].add(j)
            }
        }
    }

    val visited = BooleanArray(n)
    fun dfs(node: Int) {
        visited[node] = true

        nodeMap[node].forEach {
            if (!visited[it]) {
                dfs(it)
            }
        }
    }

    var componentCount = 0
    for (i in 0 until n) {
        if (!visited[i]) {
            dfs(i)
            componentCount++
        }
    }

    return componentCount

}


//With DFS
fun findCircleNumWithDSU(isConnected: Array<IntArray>): Int {
    val n = isConnected.size

    val edges = mutableListOf<IntArray>()

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (isConnected[i][j] == 1) {
                edges.add(intArrayOf(i, j))
            }
        }
    }

    val dsu = DSU(n)

    if (edges.size > n - 1) return 1

    for ((u, v) in edges) {
        dsu.union(u, v)
    }
    return dsu.connectedCount
}

class DSU2(n: Int) {
    val parent = Array(n) { it }
    val size = Array(n) { 1 }

    var connectedCount = n

    fun find(node: Int): Int {
        if (parent[node] != node) {
            parent[node] = find(parent[node])
        }
        return parent[node]
    }

    fun union(u: Int, v: Int) {
        val parentU = find(u)
        val parentV = find(v)

        if (parentU == parentV) return

        connectedCount--
        if (size[parentU] > size[parentV]) {
            parent[parentV] = parentU
            size[parentU] += size[parentV]
        } else {
            parent[parentU] = parentV
            size[parentV] += size[parentU]
        }
    }
}


