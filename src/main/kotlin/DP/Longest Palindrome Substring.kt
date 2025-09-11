package DP


/**
https://leetcode.com/problems/longest-palindromic-substring/
 */


fun main() {
    val res = longestPalindrome("ababd")
    println(res)
}

fun longestPalindrome(s: String): String {
    var currentLongest = 0
    var resIdx = 0

    for (i in 0 until s.length) {
        var l = i
        var r = i
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            if (currentLongest < (r - l + 1)) {
                currentLongest = r - l + 1
                resIdx = l
            }
            l--
            r++
        }

        l = i
        r = i + 1
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            if (currentLongest < (r - l + 1)) {
                currentLongest = r - l + 1
                resIdx = l
            }
            l--
            r++
        }
    }

    return s.substring(resIdx, resIdx + currentLongest)

}

