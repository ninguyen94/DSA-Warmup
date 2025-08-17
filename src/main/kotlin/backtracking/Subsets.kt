package backtracking

import binary_search.searchMatrix

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
 */
fun main() {
    val res = subsets(intArrayOf(1, 2, 3))
    println(res.toString())
}

fun subsets(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    val subset = mutableListOf<Int>()

    fun dfs(i: Int) {
        if (i >= nums.size) {
            res.add(subset.toList())
            return
        }
        subset.add(nums[i])
        dfs(i + 1)
        subset.removeAt(subset.size - 1)
        dfs(i + 1)
    }

    dfs(0)
    return res
}

//fun subsets(nums: IntArray): List<List<Int>> {
//    val res = mutableListOf<List<Int>>()
//    val subset = mutableListOf<Int>()
//    fun backtracking(idx: Int) {
//        res.add(subset.toList())
//        for (i in idx until nums.size) {
//            subset.add(nums[i])
//            backtracking(i + 1)
//            subset.removeLast()
//        }
//    }
//    backtracking(0)
//    return res
//}