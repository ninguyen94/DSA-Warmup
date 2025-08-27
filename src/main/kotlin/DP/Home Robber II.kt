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
    val res = rob2(
        intArrayOf(3, 3, 4)
    )
    println(res.toString())
}

fun rob2(nums: IntArray): Int {
    val n = nums.size
    val cache = Array(n + 1) { intArrayOf(-1, 0) }
    fun dfs(idx: Int, flg: Int): Int {
        if (idx >= n || (flg == 1 && idx == n - 1)) return 0
        if (cache[idx][flg] != -1) return cache[idx][flg]
        cache[idx][flg] = max(dfs(idx + 1, flg), nums[idx] + dfs((idx + 2), flg or if (idx == 0) 1 else 0))
        return cache[idx][flg]
    }

    return max(dfs(0, 1), dfs(1, 0))
}