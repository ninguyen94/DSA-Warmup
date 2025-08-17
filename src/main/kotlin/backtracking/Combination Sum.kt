package backtracking

import binary_search.searchMatrix

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
 */
fun main() {
    val res = combinationSum(intArrayOf(1, 2, 3), 3)
    println(res.toString())
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
//    candidates.sort()

    val res = mutableListOf<List<Int>>()
    val sol = mutableListOf<Int>()
    val length = candidates.size

    fun dfs(curIdx: Int, sum: Int) {
        if (sum == target) {
            res.add(sol.toList())
            return
        }

        if (curIdx >= length || sum > target) {
            return
        }

        sol.add(candidates[curIdx])
        
        //decision move
        dfs(curIdx, sum + candidates[curIdx])

        //decision un-choose
        sol.removeAt(sol.size - 1)
        dfs(curIdx + 1, sum)
    }

    dfs(0, 0)

    return res.toList()
}
