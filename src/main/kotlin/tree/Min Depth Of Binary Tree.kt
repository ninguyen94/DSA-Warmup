package tree

import kotlin.math.max
import kotlin.math.min

/**
 * Example:
Maximum Depth of Binary Tree
Given the root of a binary tree, return its depth.

The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val depthLeft = minDepth(root.left)
    val depthRight = minDepth(root.right)

    return if (depthLeft == 0 || depthRight == 0) 1 + max(depthLeft, depthRight) else 1 + min(depthLeft, depthRight)
}