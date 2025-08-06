package two_pointers

/**
 * Given a string s, return true if it is a palindrome, otherwise return false.
 *
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 *
 * Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 */
fun main() {
    val result = isPalindrome("A man, a plan, a canal: Panama")
    println(result)
}

fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1
    while(left < right) {
        when {
            s[left].isLetterOrDigit().not() -> {
                left++
            }
            s[right].isLetterOrDigit().not() -> {
                right--
            }
            s[left].lowercase() != s[right].lowercase() -> {
                return false
            }
            else -> {
                left++
                right--
            }
        }
    }
    return true

}