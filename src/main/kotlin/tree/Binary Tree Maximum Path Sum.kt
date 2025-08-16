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
        right = TreeNode(3)
    }
    println(maxPathSum(root))
}


fun maxPathSum(root: TreeNode?): Int {
    var res = Int.MIN_VALUE

    fun sumOfPath(root: TreeNode?): Int {
        if (root == null) return 0
        val leftMax = max(sumOfPath(root.left), 0)
        val rightMax = max(sumOfPath(root.right), 0)
        val sumAtNode = root.`val` + leftMax + rightMax
        res = max(res, sumAtNode)
        return max(leftMax, rightMax) + root.`val`
    }

    val maxRoot = sumOfPath(root)
    return max(res, maxRoot)
}
