package heap

import java.util.PriorityQueue


/*+
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/
/**
 * bucket sort
 */
fun main() {
    val twitter = MedianFinder()
    twitter.addNum(1)
    twitter.addNum(2)
    twitter.addNum(3)
    val tweet = twitter.findMedian()
    println(tweet)
}

class MedianFinder() {
    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })

    fun addNum(num: Int) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num)
            return
        }

        if (maxHeap.size > minHeap.size) {
            val max = maxHeap.peek()
            if (max > num) {
                minHeap.add(maxHeap.poll())
                maxHeap.add(num)
            } else {
                minHeap.add(num)
            }
        } else {
            val min = minHeap.peek()
            if (min < num) {
                maxHeap.add(minHeap.poll())
                minHeap.add(num)
            } else {
                maxHeap.add(num)
            }
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size > minHeap.size) {
            maxHeap.peek().toDouble()
        } else {
            (minHeap.peek() + maxHeap.peek()) / 2.0
        }
    }
}