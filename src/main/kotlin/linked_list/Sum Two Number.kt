package linked_list

/**
Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
fun main() {
    val result = ""
    println(result)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var preNode = dummy
    var head1 = l1
    var head2 = l2
    var carryNumber = 0
    while (head1 != null || head2 != null) {

        val value1 = head1?.`val` ?: 0
        val value2 = head2?.`val` ?: 0
        val sum = value1 + value2 + carryNumber
        val newNode = ListNode(sum % 10)
        carryNumber = sum / 10
        preNode.next = newNode
        head1 = head1?.next
        head2 = head2?.next
        preNode = newNode
    }

    return dummy.next

}





