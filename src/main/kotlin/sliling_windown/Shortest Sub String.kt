package sliling_windown

import kotlin.math.min

/**
Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every character in t (including duplicates)
is included in the window.
If there is no such substring, return the empty string "".
 */
fun main() {
    val result = minWindow("OUZODYXAZV", "XYZ")
    println(result)
}

fun minWindow(s: String, t: String): String {
    var left = 0

    var minLength = Int.MAX_VALUE
    var start = 0
    var valid = 0
    val targetMap = mutableMapOf<Char, Int>()
    val currentMap = mutableMapOf<Char, Int>()

    t.forEach {
        targetMap[it] = targetMap.getOrDefault(it, 0) + 1
    }

    for (right in s.indices) {
        val rightChar = s[right]

        if (targetMap.containsKey(rightChar)) {
            currentMap[rightChar] = currentMap.getOrDefault(rightChar, 0) + 1
            if (currentMap[rightChar] == targetMap[rightChar]) {
                valid++
            }
        }

        while (valid == targetMap.size) {
            if (right - left + 1 < minLength) {
                start = left
                minLength = right - left + 1
            }

            val leftChar = s[left]
            if (targetMap.containsKey(leftChar)) {
                if (currentMap[leftChar] == targetMap[leftChar]) valid--
                currentMap[leftChar] = currentMap[leftChar]!! - 1
            }
            left++
        }
    }

    return if (minLength == Int.MAX_VALUE) "" else s.substring(start, start + minLength)

}