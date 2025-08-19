package heap

/*+
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/
/**
 * bucket sort
 */
fun main() {
    val result = topKFrequent(intArrayOf(1,1, 2, 3, 4), 2)
    println(result.joinToString())
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val mapCount = mutableMapOf<Int, Int>()
    nums.forEach { num ->
        mapCount[num] = mapCount.getOrPut(num) { 0 } + 1
    }
    val sortedArray = Array(nums.size + 1) { mutableListOf<Int>() }

    mapCount.forEach { num, count ->
        sortedArray[count].add(num)
    }
    val result = mutableListOf<Int>()
    for (i in sortedArray.lastIndex downTo 1) {
        sortedArray[i].forEach { int ->
            result.add(int)
            if (result.size == k) {
                return result.toIntArray()
            }
        }
    }

    return result.toIntArray()
}