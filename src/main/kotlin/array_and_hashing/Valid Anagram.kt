package array_and_hashing

/*+
Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

 */

fun main() {
    val result = isAnagram("tap","pat")
    println(result)
}

fun isAnagram(s: String, t: String): Boolean {
    if(s.length != t.length) return false
    val count = IntArray(26)


    for(i in s.indices) {
        count[s[i]-'a']++
        count[t[i]-'a']--
    }

    return !count.any { it != 0 }
}