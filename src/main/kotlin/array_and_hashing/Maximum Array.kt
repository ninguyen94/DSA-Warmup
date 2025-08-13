package array_and_hashing

import kotlin.math.max
import kotlin.math.min

/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.
Kadane's algorithm
 */

fun main() {
    val result = maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
    println(result)
}

fun maxSubArray(nums: IntArray): Int {

    var maxSum = 0
    var preSum = nums[0]
    nums.forEach { num ->
        preSum = max(num, preSum + num)
        maxSum = max(maxSum, preSum)
    }
    return maxSum
}

fun moveZero(nums: IntArray) {

}