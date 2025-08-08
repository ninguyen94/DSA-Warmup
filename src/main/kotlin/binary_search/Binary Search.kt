package binary_search

/**
You are given an array of distinct integers nums, sorted in ascending order, and an integer target.

Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.

Your solution must run in
O(logn) time.
 */
fun main() {
    val result = search(intArrayOf(-1,0,2,4,6,8), 2)
    println(result)
}

fun search(nums: IntArray, target: Int): Int {
    fun search(start: Int, end: Int): Int {
        if (start > end) {
            return -1
        }
        val cur = start + (end - start) / 2
        return if (target == nums[cur]) {
            cur
        } else if (target > nums[cur]) {
            search(cur + 1, end)
        } else {
            search(start, cur - 1)
        }
    }
    return search(0, nums.size - 1)
}