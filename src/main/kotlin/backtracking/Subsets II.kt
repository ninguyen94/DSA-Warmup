package backtracking

import binary_search.searchMatrix

/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
 */
fun main() {
    val res = subsetsWithDup(intArrayOf(1, 2, 2))
    println(res.toString())
}

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    val subset = mutableListOf<Int>()
    nums.sort()
    fun dfs(idx: Int) {
        if (idx >= nums.size) {
            res.add(subset.toList())
            return
        }

        subset.add(nums[idx])
        dfs(idx + 1)
        subset.removeAt(subset.size - 1)
        var cur = idx + 1
        while (cur < nums.size && nums[cur - 1] == nums[cur]) {
            cur++
        }
        dfs(cur)
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