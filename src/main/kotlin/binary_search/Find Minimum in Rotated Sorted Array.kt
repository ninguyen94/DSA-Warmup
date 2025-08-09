package binary_search

/**
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 */
fun main() {
    val result = findMin(intArrayOf(11,13,15,17))
    println(result)
}

fun findMin(nums: IntArray): Int {
    var l = 0
    var r = nums.lastIndex
    while (l <= r) {
        if (nums[l] <= nums[r]) {
            return nums[l]
        }

        val m = l + (r - l) / 2

        if (nums[l] > nums[m]) {
            r = m
        } else l = m + 1
    }
    return Int.MIN_VALUE
}