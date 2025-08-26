package DP

import backtracking.combinationSum
import kotlin.math.cos
import kotlin.math.min

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */


fun main() {
    val res = minCostClimbingStairs(intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
    println(res.toString())
}


fun minCostClimbingStairs(cost: IntArray): Int {
    val length = cost.size
    val cache = IntArray(length) { -1 }
    fun dfs(stepTh: Int): Int {
        if (stepTh >= length) return 0
        if (cache[stepTh] >= 0) return cache[stepTh]
        cache[stepTh] = cost[stepTh] + min(dfs(stepTh + 1), dfs(stepTh + 2))
        return cache[stepTh]
    }

    return min(dfs(0), dfs(1))
}