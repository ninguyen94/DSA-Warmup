/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */

fun main() {
    val result = threeSum(intArrayOf(2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10))
    println(result.joinToString())
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    nums.sort()
    nums.forEachIndexed { i, num ->
        if (num > 0) return@forEachIndexed
        if (i > 0 && (num == nums[i - 1])) return@forEachIndexed
        var left = i + 1
        var right = nums.lastIndex
        while (left < right) {
            val sum = num + nums[left] + nums[right]
            when {
                sum < 0 -> left++
                sum > 0 -> right--
                else -> {
                    res.add(listOf(num, nums[left], nums[right]))
                    left++
                    right--
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++
                    }
                }
            }
        }
    }

    return res
}