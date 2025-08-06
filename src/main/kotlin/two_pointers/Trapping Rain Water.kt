package two_pointers

import kotlin.math.max

/**
You are given an array of non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.

Return the maximum area of water that can be trapped between the bars.
 */
fun main() {
    val result = trap(intArrayOf(4,2,0,3,2,5))
    println(result)
}

fun trap(height: IntArray): Int {
    var res = 0
    var left = 0
    var right = height.lastIndex
    var leftWall = height[left]
    var rightWall = height[right]
    while (left < right) {
        if (leftWall < rightWall) {
            left++
            leftWall = max(leftWall, height[left])
            res += leftWall - height[left]
        } else {
            right--
            rightWall = max(rightWall, height[right])
            res += rightWall - height[right]
        }
    }
    return res
}