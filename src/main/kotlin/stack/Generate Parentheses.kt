package stack


/**
 * Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
fun main() {
    val result = generateParenthesis(4)
    println(result)
}

fun generateParenthesis(n: Int): List<String> {
    val res = mutableListOf<String>()
    val stack = mutableListOf<Char>()
    fun backtracking(openBracket: Int, closeBracket: Int) {
        if (openBracket == n && closeBracket == n) {
            res.add(stack.joinToString(""))
            return
        }

        if (openBracket < n) {
            stack.add('(')
            backtracking(openBracket + 1, closeBracket)
            stack.removeLast()
        }

        if (closeBracket < openBracket) {
            stack.add(')')
            backtracking(openBracket, closeBracket + 1)
            stack.removeLast()
        }
    }
    backtracking(0, 0)
    return res
}
