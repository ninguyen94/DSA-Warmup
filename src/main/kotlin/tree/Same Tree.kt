package tree

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true

    if (p != null && q != null) {
        if (p.`val` != q.`val`) return false
        if (!isSameTree(p.left, q.left)) return false
        if (!isSameTree(p.right, q.right)) return false
        return true
    }

    return false
}
