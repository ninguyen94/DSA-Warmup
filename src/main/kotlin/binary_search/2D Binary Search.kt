package binary_search

/**
 * Search a 2D Matrix
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 */
fun main() {
    val result = searchMatrix(
        arrayOf<IntArray>(
            intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(14, 20, 30, 40)
        ), 15
    )
    println(result)
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val cols = matrix[0].size
    var l = 0
    var r = matrix.lastIndex * cols + matrix[matrix.lastIndex].lastIndex

    while (l <= r) {
        val m = l + (r - l) / 2
        val mValue = matrix[m / cols][m % cols]
        when {
            mValue > target -> r = m - 1
            mValue < target -> l = m + 1
            else -> return true
        }
    }
    return false
}




