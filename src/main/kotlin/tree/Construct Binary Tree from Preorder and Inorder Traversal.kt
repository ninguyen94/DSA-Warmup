package tree

import kotlin.math.max

/**
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 */

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    var preIdx = 0
    val mapNode = inorder.withIndex().associate { (index, value) -> value to index }
    fun dfs(left: Int, right: Int): TreeNode? {
        if (left > right) return null

        val root = TreeNode(preorder[preIdx])
        preIdx++

        val mid = mapNode[root.`val`]!!
        root.left = dfs(left, mid - 1)
        root.right = dfs(mid + 1, right)
        return root
    }

    return dfs(0, inorder.size - 1)

}



