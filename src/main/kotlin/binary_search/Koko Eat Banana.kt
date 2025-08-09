package binary_search

import kotlin.math.ceil

/**
 * Koko Eating Bananas
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.
 */
fun main() {
    val result = minEatingSpeed(intArrayOf(1,4,3,2),9)
    print(result)
}

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var r = piles.max()
    var l = 1
    var result = r

    while (l <= r) {
        val k = (l + r) / 2
        var totalTime = 0L
        for (p in piles) {
            totalTime += ceil(p.toDouble() / k).toLong()
        }
        if (totalTime <= h) {
            result = k
            r = k - 1
        } else {
            l = k + 1
        }
    }

    return result
}




