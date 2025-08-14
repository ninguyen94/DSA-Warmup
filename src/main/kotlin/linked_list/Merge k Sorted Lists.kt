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

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null

    return mergeKListRange(lists, 0, lists.size - 1)
}

fun mergeKListRange(lists: Array<ListNode?>, start: Int, end: Int): ListNode? {
    if (start == end) return lists[end]

    val mid = (start + end) / 2
    val left = mergeKListRange(lists, start, mid)
    val right = mergeKListRange(lists, mid + 1, end)

    return mergeTwoLists(left, right)
}







