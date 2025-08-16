package tree

/**
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom. */


fun rightSideView(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()

    fun addDescendant(root: TreeNode?, level: Int) {
        if (root == null) return
        if (list.size <= level) {
            list.add(root.`val`)
        } else {
            list[level] = root.`val`
        }
        addDescendant(root.left, level + 1)
        addDescendant(root.right, level + 1)
    }

    addDescendant(root, 0)
    return list
}


