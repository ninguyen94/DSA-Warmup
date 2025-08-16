package tree

import two_pointers.maxProfit
import kotlin.math.max

/**
 * Example:
Maximum Depth of Binary Tree
Given the root of a binary tree, return its depth.

The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

fun main() {
    val root = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(2)
    }
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(7)
    val codec = Codec()
    val string = codec.serialize(root)
    val returnRoot = codec.deserialize(string)
    println(returnRoot)
}


class Codec {

    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val res = mutableListOf<String>()

        fun dfs(node: TreeNode?) {
            if (node == null) {
                res.add("N")
                return
            }
            res.add(node.`val`.toString())
            dfs(node.left)
            dfs(node.right)
        }

        dfs(root)
        return res.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val vals = data.split(",")
        var i = 0

        fun dfs(): TreeNode? {
            if (vals[i] == "N") {
                i++
                return null
            }
            val node = TreeNode(vals[i].toInt())
            i++
            node.left = dfs()
            node.right = dfs()
            return node
        }

        return dfs()
    }
}
