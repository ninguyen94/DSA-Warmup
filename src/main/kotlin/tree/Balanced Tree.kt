package tree

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
Balanced Binary Tree
Given a binary tree, return true if it is height-balanced and false otherwise.

A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */

fun isBalanced(root: TreeNode?): Boolean {
    return highOfTree(root) >= 0
}

fun highOfTree(root: TreeNode?): Int {
    if (root == null) return 0
    val leftHeight = highOfTree(root.left)
    if (leftHeight < 0) return -1
    val rightHeight = highOfTree(root.right)
    if (rightHeight < 0) return -1
    return when {
        abs(leftHeight - rightHeight) > 1 -> return -1
        else -> max(leftHeight, rightHeight) + 1
    }
}


