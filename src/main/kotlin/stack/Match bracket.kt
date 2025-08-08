package stack

import java.util.Deque
import java.util.PriorityQueue

/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */
fun main() {
    val result = isValid("([{}])")
    println(result)
}

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    val charMap = hashMapOf(')' to '(', '}' to '{', ']' to '[')
    s.forEach { char ->
        if (char in charMap) {
            if (stack.isNotEmpty() && charMap[char] == stack.last()) {
                stack.removeLast()
            } else {
                return false
            }
        } else {
            stack.addLast(char)
        }
    }

    return stack.isEmpty()
}
