package stack

/**
Daily Temperatures
You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.

Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day.
If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.
 */
fun main() {
    val result = dailyTemperatures(intArrayOf(22,21,20))
    print(result.contentToString()) // return -2
}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val deque = ArrayDeque<Pair<Int, Int>>()
    val res = IntArray(temperatures.size) { 0 }
    temperatures.forEachIndexed { index, cur ->
        while (deque.isNotEmpty() && deque.last().first < cur) {
            val last = deque.removeLast()
            res[last.second] = index - last.second
        }
        deque.addLast(cur to index)

    }
    return res
}