package tree

/**
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */


fun levelOrder(root: TreeNode?): List<List<Int>> {
    val map = mutableMapOf<Int, MutableList<Int>>()

    fun addDescendant(root: TreeNode?, level: Int) {
        if (root == null) return

        // getOrPut avoids creating unnecessary temp lists
        map.getOrPut(level) { mutableListOf() }.add(root.`val`)

        // Use level + 1 instead of level++ for recursion
        addDescendant(root.left, level + 1)
        addDescendant(root.right, level + 1)
    }

    addDescendant(root, 0)
    return map.values.toList()
}


