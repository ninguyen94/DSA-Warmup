package two_pointers

/**
Given an array of integers numbers that is sorted in non-decreasing order.

Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.

There will always be exactly one valid solution.

Your solution must use O(1) additional space.
 */
fun main() {
    val result = twoSum(intArrayOf(2,3,4),7)
    println(result.joinToString())
}

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.lastIndex
    while (left < right) {
        val tempSum = numbers[left] + numbers[right]
        when {
            tempSum == target -> return intArrayOf(left, right)
            tempSum > target -> right--
            else -> left++
        }
    }
    return intArrayOf(left, right)
}