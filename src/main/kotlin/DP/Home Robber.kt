package DP

import backtracking.combinationSum
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.min

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */


fun main() {
    val res = rob(
        intArrayOf(2, 7, 9, 3, 1)
    )
    println(res.toString())
}

fun rob(nums: IntArray): Int {
    val cache = IntArray(nums.size) { -1 }
    fun dfs(idx: Int): Int {
        if (idx >= nums.size) return 0
        if (cache[idx] != -1) return cache[idx]
        cache[idx] =  nums[idx] + max(dfs(idx + 2), dfs((idx + 3)))
        return cache[idx]
    }
    return max(dfs(0), dfs(1))
}

fun robOptimizeSpace(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    if (nums.size > 2) {
        nums[nums.size - 3] += nums[nums.size - 1]
        for (i in nums.size - 4 downTo 0) {
            nums[i] += max(nums[i + 2], nums[i + 3])
        }
    }

    return max(nums[0], nums[1])
}