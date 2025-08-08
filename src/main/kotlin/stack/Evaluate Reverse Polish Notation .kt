package stack

import java.util.Stack

/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
fun main() {
    val result = evalRPN(arrayOf("1","2","+","3","*","4","-"))
    println(result)
}

fun evalRPN(tokens: Array<String>): Int {
    val stack = Stack<Int>()
    tokens.forEach { s ->
        if (s.isOperator()) {
            val result = s.math(stack.pop(), stack.pop())
            stack.push(result)
        } else {
            stack.push(s.toInt())
        }
    }
    return stack.pop()
}

fun String.isOperator(): Boolean {
    return this == "+" || this == "-" || this == "*" || this == "/"
}

fun String.math(num1: Int, num2: Int): Int {
    return when (this) {
        "-" -> num2 - num1
        "*" -> num1 * num2
        "/" -> num2 / num1
        else -> num1 + num2
    }
}
