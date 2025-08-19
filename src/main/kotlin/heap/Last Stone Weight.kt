package heap

import java.util.PriorityQueue
import kotlin.math.abs

/*+
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/
/**
 * bucket sort
 */
fun main() {
    val result = lastStoneWeight(intArrayOf(2,7,4,1,8,1))
    println(result)
}

fun lastStoneWeight(stones: IntArray): Int {
    val heap = PriorityQueue<Int>(compareByDescending { it })
    stones.forEach {
        heap.add(it)
    }

    if (heap.size < 2) return heap.peek()

    while (heap.size > 1) {
        val stone1 = heap.poll()
        val stone2 = heap.poll()
        heap.add(abs(stone1 - stone2))
    }
    return heap.peek()
}