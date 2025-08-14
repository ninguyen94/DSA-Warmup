package linked_list

/**
Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
fun main() {
    val result = ""
    println(result)
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head?.next == null) return null
    var first: ListNode? = head
    var second: ListNode? = ListNode(-1)
    second?.next = head
    var count = 1

    //move first pointer to nth-position
    while (count < n) {
        first = head.next
        count++
    }

    //if n == length, remove head, return next node
    if (first?.next == null) {
        return head.next
    }

    //move first point until end of list, second point will follow up
    while (first?.next != null) {
        first = first.next
        second = second?.next
    }

    //when first point at last node, second pointer will be pointed at the node right before the removed node
    var tmp = second?.next?.next
    second?.next = tmp
    return head

}




