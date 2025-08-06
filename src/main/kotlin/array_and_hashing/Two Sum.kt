package array_and_hashing

import kotlin.math.max
import kotlin.math.min

/*
Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first.
 */

fun main() {
    val result = twoSum(intArrayOf(1, 2, 3, 4), 3)
    println(result)
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val findMap = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        if (findMap.containsKey(nums[i])) {
            return intArrayOf(min(i, findMap[nums[i]]!!), max(i, findMap[nums[i]]!!))
        }

        findMap.put(target - nums[i], i)
    }
    return intArrayOf()
}