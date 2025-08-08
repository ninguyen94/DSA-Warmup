package sliling_windown

import java.util.Deque
import java.util.PriorityQueue

/**
Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every character in t (including duplicates)
is included in the window.
If there is no such substring, return the empty string "".
 */
fun main() {
    val result = maxSlidingWindowByDeque(intArrayOf(9, 10, 9, -7, -4, -8, 2, -6), 5)
    println(result.joinToString())
}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val res = mutableListOf<Int>()
    val heap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.first })
    for (r in 0 until nums.size) {
        heap.add(nums[r] to r)

        if (r >= k - 1) {
            while (heap.peek().second <= r - k) {
                heap.poll()
            }
            res.add(heap.peek().first)
        }
    }
    return res.toIntArray()
}

fun maxSlidingWindowByDeque(nums: IntArray, k: Int): IntArray {
    val res = mutableListOf<Int>()
    val deque = ArrayDeque<Int>()
    for (i in nums.indices) {
        while (deque.isNotEmpty() && nums[i] > nums[deque.last()]) {
            deque.removeLast()
        }
        deque.addLast(i)

        while (deque.first() <= i - k) {
            deque.removeFirst()
        }

        if (i >= k - 1) {
            res.add(nums[deque.first()])
        }
    }
    return res.toIntArray()
}