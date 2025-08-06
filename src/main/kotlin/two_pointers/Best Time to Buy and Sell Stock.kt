package two_pointers

import kotlin.math.max
import kotlin.math.min

/**
You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.

You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.

Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
 */
fun main() {
    val result = maxProfit(intArrayOf(10,8,7,5,2))
    println(result)
}

fun maxProfit(prices: IntArray): Int {
    var startPrice = prices[0]
    var profit = 0
    prices.forEach { price ->
        startPrice = min(startPrice, price)
        profit = max(profit, price - startPrice)
    }
    return profit
}