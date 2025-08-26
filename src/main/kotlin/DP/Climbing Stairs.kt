package DP

import backtracking.combinationSum

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */


fun main() {
    val res = climbStairs(4)
    println(res.toString())
}


fun climbStairs(n: Int): Int {
    val cache = IntArray(n + 1) { -1 }
    cache[0] = 1
    fun dfs(goal: Int): Int {
        if (goal < 0) return 0

        if (cache[goal] >= 0) return cache[goal]
        cache[goal] = dfs(goal - 1) + dfs(goal - 2)

        return cache[goal]
    }

    return dfs(n)
}