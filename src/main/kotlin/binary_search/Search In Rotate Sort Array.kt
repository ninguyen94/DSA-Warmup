package binary_search

/**
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 */
fun main() {
    val result = searchInSortArray(intArrayOf(3,4,5,6,1,2), 1)
    println(result)
}

fun searchInSortArray(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.lastIndex
    while (l <= r) {

        val m = l + (r - l) / 2

        if (nums[m] == target) return m

        if (nums[l] > nums[m]) {
            if (nums[l] <= target || target < nums[m]) {
                r = m - 1
            } else {
                l = m + 1
            }
        } else if (nums[l] <= target && target < nums[m]) {
            r = m - 1
        } else {
            l = m + 1
        }
    }

    return -1
}