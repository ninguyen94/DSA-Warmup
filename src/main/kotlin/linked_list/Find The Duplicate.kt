package linked_list

import kotlin.math.abs

/**
Find the Duplicate Number
You are given an array of integers nums containing n + 1 integers. Each integer in nums is in the range [1, n] inclusive.

Every integer appears exactly once, except for one integer which appears two or more times. Return the integer that appears more than once.
 */
fun main() {
    val result = ""
    println(result)
}

fun findDuplicate(nums: IntArray): Int {
    nums.forEach { num ->
        val idx = nums[abs(num) - 1]
        if (nums[idx] < 0) return idx
        nums[idx] *= -1
    }

    return -1
}




