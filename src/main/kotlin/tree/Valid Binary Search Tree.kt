package tree

import kotlin.math.max

/**
Valid Binary Search Tree
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys strictly less than the node's key.
The right subtree of a node contains only nodes with keys strictly greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */

fun isValidBST(root: TreeNode?): Boolean {
    fun isValid(root: TreeNode?, leftValue: Long, rightValue: Long): Boolean {
        if (root == null) return true
        if (root.`val` <= leftValue || root.`val` >= rightValue) {
            return false
        }

        return isValid(root.left, leftValue, root.`val`.toLong()) && isValid(
            root.right, root.`val`.toLong(), rightValue
        )
    }

    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)
}



