package graph

fun main() {
    val myGraph = Graph()
    myGraph.addVertex(0)
    myGraph.addVertex(1)
    myGraph.addVertex(2)
    myGraph.addVertex(3)
    myGraph.addVertex(4)
    myGraph.addVertex(5)
    myGraph.addVertex(6)
    myGraph.addEdge(3, 1)
    myGraph.addEdge(3, 4)
    myGraph.addEdge(4, 2)
    myGraph.addEdge(4, 5)
    myGraph.addEdge(1, 2)
    myGraph.addEdge(1, 0)
    myGraph.addEdge(0, 2)
    myGraph.addEdge(6, 5)

    myGraph.showConnections()
}

class Graph {
    var numOfNodes = 0
    val mapEdges = mutableMapOf<Int, MutableList<Int>>()

    fun addVertex(node: Int) {
        numOfNodes++
        mapEdges.getOrPut(node, { mutableListOf<Int>() })
    }

    fun addEdge(node1: Int, node2: Int) {
        mapEdges[node1]?.add(node2)
        mapEdges[node2]?.add(node1)
    }

    fun showConnections() {
        val allNodes = mapEdges.keys
        for (node in allNodes) {
            val nodeConnections = mapEdges[node] ?: mutableListOf()
            var connections = ""
            for (vertex in nodeConnections) {
                connections += "$vertex "
            }
            println("$node-->$connections")
        }
    }
}