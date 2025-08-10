package linked_list

/**
Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
fun main() {
    val result = ""
    println(result)
}

fun reorderList(head: ListNode?): Unit {
    if (head == null || head.next == null) return

    var slow = head
    var fast = head.next
    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    val second = slow?.next
    slow?.next = null

    //reverse
    var prev: ListNode? = null
    var cur = second
    while (cur != null) {
        val tmp = cur.next
        cur.next = prev
        prev = cur
        cur = tmp
    }

    //merge two linked list
    var l1 = head
    var l2 = prev
    while (l1 != null && l2 != null) {
        val tmp1 = l1.next
        val tmp2 = l2.next
        l1.next = l2
        l2.next = tmp1
        l1 = tmp1
        l2 = tmp2
    }

}




