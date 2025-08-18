package backtracking

import binary_search.searchMatrix

/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.
 */
fun main() {
    val res = combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8)
    println(res.toString())
}

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    candidates.sort()

    fun dfs(idx: Int, currentList: MutableList<Int>, sum: Int) {
        if (sum == target) {
            res.add(currentList.toList())
            return
        }

        //move
        for (i in idx until candidates.size) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue
            }

            if (sum + candidates[i] > target || candidates[i] > target) {
                break
            }
            currentList.add(candidates[i])
            dfs(i + 1, currentList, sum + candidates[i])
            //back
            currentList.removeLast()
        }

    }
    dfs(0, mutableListOf(), 0)
    return res
}
