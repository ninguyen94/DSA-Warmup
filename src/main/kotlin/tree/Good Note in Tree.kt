package tree

import kotlin.math.max

/**
Count Good Nodes in Binary Tree
Within a binary tree, a node x is considered good if the path from the root of the tree
to the node x contains no nodes with a value greater than the value of node x

Given the root of a binary tree root, return the number of good nodes within the tree.
 */


fun goodNodes(root: TreeNode?): Int {
    var count = 0

    fun countGoodNode(current: TreeNode?, preNodeVal: Int) {
        if (current == null) return
        val currentVal = current.`val`
        if (preNodeVal <= currentVal) {
            count++
        }
        val max = max(currentVal, preNodeVal)
        countGoodNode(current.left, max)
        countGoodNode(current.right, max)
    }

    countGoodNode(root, Int.MIN_VALUE)
    return count
}


