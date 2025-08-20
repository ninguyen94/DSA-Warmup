package heap

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/*+
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/
/**
 * bucket sort
 */
fun main() {
    val result = kClosest(arrayOf(intArrayOf(5, -1), intArrayOf(3, 3), intArrayOf(-2, 4)), 2)
    println(result.joinToString())
}

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val heap = PriorityQueue<IntArray>(compareBy { it[0] * it[0] + it[1] * it[1] })
    points.forEach {
        heap.add(it)
    }
    val res = mutableListOf<IntArray>()
    while (res.size < k) {
        val closest = heap.poll()
        res.add(closest)
    }
    return res.toTypedArray()
}