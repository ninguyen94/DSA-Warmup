package two_pointers

import kotlin.math.max
import kotlin.math.min

/**

 */
fun main() {
    val result = maxArea(intArrayOf(1,1))
    println(result)
}

fun maxArea(height: IntArray): Int {
    var maxArea = 0
    var left = 0
    var right = height.lastIndex
    while (left < right) {
        val are = (right - left) * min(height[left], height[right])
        maxArea = max(maxArea, are)
        if (height[left] < height[right] ) {
            left++
        } else {
            right--
        }
    }
    return maxArea
}