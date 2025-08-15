package tree

import kotlin.math.max

/**
 * Example:
Maximum Depth of Binary Tree
Given the root of a binary tree, return its depth.

The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + max(maxDepth(root.left), maxDepth(root.right))
    }
}