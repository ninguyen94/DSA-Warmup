package tree

import kotlin.math.max
import kotlin.math.min

/**
 * Example:
Diameter of Binary Tree
The diameter of a binary tree is defined as the length of the longest path between any two nodes within the tree. The path does not necessarily have to pass through the root.

The length of a path between two nodes in a binary tree is the number of edges between the nodes. Note that the path can not include the same node twice.

Given the root of a binary tree root, return the diameter of the tree.*/

var longestLength = Int.MIN_VALUE

fun diameterOfBinaryTree(root: TreeNode?): Int {
    findLongest(root)
    return longestLength
}

fun findLongest(root: TreeNode?): Int {
    if (root == null) return 0
    val leftDiameter = findLongest(root.left)
    val rightDiameter = findLongest(root.right)
    longestLength = max(longestLength, leftDiameter + rightDiameter)
    return max(leftDiameter, rightDiameter) + 1
}


