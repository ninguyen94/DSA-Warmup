package stack

import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min

/**
There are n cars traveling to the same destination on a one-lane highway.

You are given two arrays of integers position and speed, both of length n.

position[i] is the position of the ith car (in miles)
speed[i] is the speed of the ith car (in miles per hour)
The destination is at position target miles.

A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.

A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.
10,8,0,5,3], speed = [2,4,1,1,3]
If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.

Return the number of different car fleets that will arrive at the destination.
 */
fun main() {
    val result = carFleet(10, intArrayOf(6, 8), intArrayOf(3, 2))
    print(result) // return -2
}

fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    val pair = position.zip(speed).sortedByDescending { it.first }
    val stack = mutableListOf<Double>()

    for ((p, s) in pair) {
        val time = (target - p).toDouble() / s
        stack.add(time)
        if (stack.size >= 2 && stack[stack.size - 1] <= stack[stack.size - 2]) {
            stack.removeAt(stack.size - 1)
        }
    }

    return stack.size
}