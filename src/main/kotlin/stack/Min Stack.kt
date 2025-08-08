package stack

import java.util.Stack
import kotlin.math.min

/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */
fun main() {
    val minStack = MinStack2()
    print(minStack.push(1))
    print(minStack.push(2))
    print(minStack.push(0))
    print(minStack.getMin()) // return -3
    print(minStack.pop())
    print(minStack.top())// return 0
    print(minStack.getMin()) // return -2
}

class MinStack()

{

    val stack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        val minValue = if (minStack.isNotEmpty()) min(`val`, minStack.last()) else `val`
        minStack.addLast(minValue)
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }

}

class MinStack2 {

    private var min: Int = Int.MAX_VALUE
    private var stack = Stack<Int>()

    fun push(x: Int) {
        if (x <= min) {
            stack.push(min)
            min = x
        }
        stack.push(x)
    }

    fun pop() {
        if (stack.pop() == min) {
            min = stack.pop()!!
        }
    }

    fun top(): Int {
        return stack.peek()!!
    }

    fun getMin(): Int {
        return min
    }

}
