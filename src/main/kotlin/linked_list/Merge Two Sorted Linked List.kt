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

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var head1 = list1
    var head2 = list2
    val dummyHead = ListNode(0)
    var newNote: ListNode? = dummyHead

    while (head1 != null && head2 != null) {

        if (head1.`val` < head2.`val`) {
            newNote?.next = head1
            head1 = head1.next
        } else {
            newNote?.next = head2
            head2 = head2.next
        }
        newNote = newNote?.next
    }

    newNote?.next = head1 ?: head2

    return dummyHead.next

}





