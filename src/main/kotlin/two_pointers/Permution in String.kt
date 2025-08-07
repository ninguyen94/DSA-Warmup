package two_pointers

import kotlin.math.max

/**
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
 */
fun main() {
    val result = checkInclusion("ab", "eidboaoo")
    println(result)
}

fun checkInclusion(s1: String, s2: String): Boolean {
    if (s2.length < s1.length) return false

    val countSub = IntArray(26)
    val countCheck = IntArray(26)

    for (i in s1.indices) {
        countSub[s1[i] - 'a']++
        countCheck[s2[i] - 'a']++
    }
    var match = 0

    for (i in 0 until 26) {
        if (countSub[i] == countCheck[i]) match++
    }

    //window size at init 0 -> s1.length
    var l = 0

    //shift window to the right one by one
    for (r in s1.length until s2.length) {
        if (match == 26) return true

        //increase window size
        val rightCharIndex = s2[r] - 'a'
        //update count
        countCheck[rightCharIndex]++
        if (countSub[rightCharIndex] == countCheck[rightCharIndex]) {
            match++
        } else if (countSub[rightCharIndex] + 1 == countCheck[rightCharIndex]) {
            //decrease match when add another position
            match--
        }

        //decrease window size
        val leftCharIndex = s2[l] - 'a'
        countCheck[leftCharIndex]--
        if (countSub[leftCharIndex] == countCheck[leftCharIndex]) {
            match++
        } else if (countSub[leftCharIndex] - 1 == countCheck[leftCharIndex]) {
            match--
        }

        l++

    }
    return match == 26
}