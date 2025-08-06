package array_and_hashing

import kotlin.math.max
import kotlin.math.min

/*
Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first.
 */

fun main() {
    val result = encode(listOf("i", "love", "you"))
    println(result)
    val decode = decode(result)
    println(decode.joinToString())
}

fun encode(strs: List<String>): String {
    val builder = StringBuilder()
    strs.forEach { str ->
        str.forEach { char ->
            builder.append(char).append(char)
        }
        builder.append("01")
    }
    return builder.toString()
}

fun decode(encoded: String): List<String> {
    val result = mutableListOf<String>()
    val builder = StringBuilder()
    var i = 0
    while (i < encoded.length) {
        if (encoded[i] == encoded[i + 1]) {
            builder.append(encoded[i])
        } else {
           result.add(builder.toString())
           builder.clear()
        }
        i = i + 2
    }
    return result
}