package graph

fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    node1.neighbors.add(node2)
    node1.neighbors.add(node4)
    node2.neighbors.add(node1)
    node2.neighbors.add(node3)
    node3.neighbors.add(node2)
    node3.neighbors.add(node4)
    node4.neighbors.add(node1)
    node4.neighbors.add(node3)

    val res = cloneGraph(node1)
    println(res)
}

fun cloneGraph(node: Node?): Node? {
    val nodeList = mutableMapOf<Int, Node>()
    if (node == null) return null
    fun clone(node: Node?): Node? {
        if (node == null) return null
        //return node if it existed
        if (nodeList.contains(node.`val`)) return nodeList[node.`val`]
        //create new node
        val newNode = Node(node.`val`)
        nodeList[node.`val`] = newNode
        node.neighbors.forEach {
                newNode.neighbors.add(clone(it))
        }
        return newNode
    }
    return clone(node)
}

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}