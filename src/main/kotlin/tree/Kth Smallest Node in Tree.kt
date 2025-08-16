package tree

import kotlin.math.max

/**
Kth Smallest Integer in BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.
 */

fun kthSmallest(root: TreeNode?, k: Int): Int {
    var count = 0
    var res = -1
    fun getCount(root: TreeNode?) {
        if (root == null || count > k) return
        getCount(root.left)
        count++
        if (count == k) {
            res = root.`val`
        }
        getCount(root.right)
    }

    getCount(root)
    return res
}



