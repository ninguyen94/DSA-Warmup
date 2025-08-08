package two_pointers

import kotlin.math.max

/**
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
fun main() {
    val result = characterReplacement("AABABBA",1)
    println(result)
}

fun characterReplacement(s: String, k: Int): Int {
    val count = mutableMapOf<Char, Int>()
    var res = 0
    var maxF = 0
    var l = 0
    for (r in s.indices) {
        count[s[r]] = count.getOrDefault(s[r], 0) + 1
        maxF = max(maxF, count[s[r]]!!)

        while (r - l + 1 - maxF > k) {
            count[s[l]] = count[s[l]]!! - 1
            l++
        }

        res = max(res, r - l + 1)
    }

    return res
}