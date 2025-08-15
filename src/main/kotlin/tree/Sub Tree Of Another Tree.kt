package tree


/**
Subtree of Another Tree
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (subRoot == null) return true
    if (root == null) return false

    if (isSame(root, subRoot)) return true

    return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot)
}

fun isSame(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null && subRoot == null) return true
    if (root == null || subRoot == null || root.`val` != subRoot.`val`) return false
    return isSameTree(root.right, subRoot.right) && isSameTree(root.left, subRoot.left)
}
