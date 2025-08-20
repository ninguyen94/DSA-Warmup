package heap

import java.util.PriorityQueue

/*+
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/
/**
 * bucket sort
 */
fun main() {
    val result = leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2)
    println(result)
}

fun leastInterval(tasks: CharArray, n: Int): Int {
    val countCPU = IntArray(26) { 0 }
    val heap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.first })
    val coolQueue = ArrayDeque<Pair<Int, Int>>()
    tasks.forEach {
        countCPU[it - 'A']++
    }

    //add to heap for sorting max
    countCPU.forEachIndexed { index, i ->
        if (i != 0) {
            heap.add(i to index)
        }
    }
    var cooldown = n

    var executeTime = 0

    while (heap.isNotEmpty() || coolQueue.isNotEmpty()) {
        val executeTask = heap.poll()
        executeTime++

        if (coolQueue.isEmpty()) {
            cooldown = n
        } else {
            cooldown--
        }

        //put to cooling
        if (executeTask.first - 1 > 0) {
            coolQueue.add(executeTask.first - 1 to executeTask.second)
        }

        if (cooldown == 0 || (heap.isEmpty() && coolQueue.isNotEmpty())) {
            executeTime += cooldown
            while (coolQueue.isNotEmpty()) {
                heap.add(coolQueue.removeFirst())
            }
        }
    }
    return executeTime
}