package stack

import kotlin.math.max


/**
Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.
 */
fun main() {
    val result = largestRectangleArea(intArrayOf(7, 1, 7, 2, 2, 4))
    print(result) // return -2
}

fun largestRectangleArea(heights: IntArray): Int {
    val stack = mutableListOf<Pair<Int, Int>>()
    var maxArea = 0

    for (i in heights.indices) {
        val cur = heights[i]
        var start = i
        while (stack.isNotEmpty() && cur < stack[stack.lastIndex].second) {
            maxArea = max(
                maxArea, (i - stack[stack.lastIndex].first) * stack[stack.lastIndex].second
            )
            start = stack[stack.lastIndex].first
            stack.removeAt(stack.lastIndex)
        }
        stack.add(start to cur)
    }

    for ((i, height) in stack) {
        maxArea = max(
            maxArea, (heights.size - i) * height
        )
    }

    return maxArea
}