package array_and_hashing

import kotlin.math.max
import kotlin.math.min

/*
Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first.
 */

/**
 * prefix and suffix
 */

fun main() {
    val result = productExceptSelf(intArrayOf(-1,1,0,-3,3))
    println(result.joinToString())
}

fun productExceptSelf(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    var prefix = 1

    for(i in nums.indices) {
        result[i] = prefix
        prefix *= nums[i]
    }

    var suffix = 1
    for(i in nums.indices.reversed()) {
        result[i] *= suffix
        suffix *= nums[i]
    }

    return result
}
