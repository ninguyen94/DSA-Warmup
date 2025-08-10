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
    if (list1 == null) return list2
    if (list2 == null) return list1
    var head1 = list1
    var head2 = list2

    while (head1 != null && head2 != null) {
        if (head1.`val` < head2.`val`) {

            while (head1 != null && head1.next != null && head1.`val` < head2.`val`) {
                head1 = head1.next
            }

            val temp = head1?.next
            head1?.next = head2
            head2 = head2.next
            head1 = temp

        } else {
            while (head2 != null && head2.next != null && head1.`val` > head2.`val`) {
                head2 = head2.next
            }
            val temp = head2?.next
            head2?.next = head1
            head1 = head1.next
            head2 = temp
        }
    }
    return if (list2.`val` < list1.`val`) list1 else list1
}





