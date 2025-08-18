package backtracking

import binary_search.searchMatrix

/*
Given an array nums of distinct integers,
return all the possible permutations.
You can return the answer in any order.
 */
fun main() {
    val res = permute(intArrayOf(1, 2, 3))
    println(res.toString())
}

fun permute(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    val length = nums.size
    val set = BooleanArray(length) { false }
    val currentList = mutableListOf<Int>()
    fun dfs() {

        if (currentList.size == length) {
            res.add(currentList.toList())
            return
        }

        for (i in 0 until length) {
            if (set[i]) {
                continue
            }
            currentList.add(nums[i])
            set[i] = true
            dfs()
            currentList.removeAt(currentList.size - 1)
            set[i] = false
        }
    }
    dfs()
    return res.toList()
}
