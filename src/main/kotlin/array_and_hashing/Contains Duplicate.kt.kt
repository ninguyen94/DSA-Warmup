package array_and_hashing

/*+
Contains Duplicate
Given an integer array nums, return true if any value appears more than once in the array,
otherwise return false.

 */

fun main() {
    val result = containsDuplicate(intArrayOf(1,2,3,4))
    println(result)
}

fun containsDuplicate(nums: IntArray): Boolean {
    val setElement = mutableSetOf<Int>()
    nums.forEach { num ->
        if (setElement.contains(num)) {
            return true
        }
        setElement.add(num)
    }

    return false
}