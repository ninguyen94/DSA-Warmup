package two_pointers

import kotlin.math.max

/**
 * Given a string s, return true if it is a palindrome, otherwise return false.
 *
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 *
 * Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 */
fun main() {
    val result = lengthOfLongestSubstring("aab")
    println(result)
}

fun lengthOfLongestSubstring(s: String): Int {
    val mp = HashMap<Char, Int>()
    var l = 0
    var res = 0

    for (r in s.indices) {
        if (s[r] in mp) {
            l = maxOf(mp[s[r]]!! + 1, l)
        }
        mp[s[r]] = r
        res = maxOf(res, r - l + 1)
    }
    return res

}