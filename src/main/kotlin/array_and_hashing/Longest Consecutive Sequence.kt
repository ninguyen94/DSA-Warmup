package array_and_hashing

import kotlin.math.max
import kotlin.math.min

/*
Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first.
 */

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 */


/*
Find longest
 */
fun main() {
    val result = longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1))
    println(result)
}

fun longestConsecutive(nums: IntArray): Int {
    val countMap = mutableMapOf<Int, Int>()
    var res = 0
    nums.forEach { num ->
        if (countMap[num] == null) {
            val left = countMap[num - 1] ?: 0
            val right = countMap[num + 1] ?: 0
            val sum = left + right + 1
            countMap[num] = sum
            countMap[num - left] = sum
            countMap[num + right] = sum
            res = max(res, sum)
        }
    }
    return res
}

fun longestConsecutiveByFindHead(nums: IntArray): Int {
    val numSet = nums.toSet()
    var longest = 0

    for (num in numSet) {
        if ((num - 1) !in numSet) {
            var length = 1
            while ((num + length) in numSet) {
                length++
            }
            longest = maxOf(longest, length)
        }
    }
    return longest
}