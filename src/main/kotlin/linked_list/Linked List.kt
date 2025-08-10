package linked_list

/**
 * Search a 2D Matrix
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 */
fun main() {
    val result = ""
    println(result)
}

fun reverseList(head: ListNode?): ListNode? {
    var preNote: ListNode? = null
    var curr = head
    while (curr != null) {
        val temp = curr.next
        curr.next = preNote
        preNote = curr
        curr = temp
    }
    return preNote
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}




