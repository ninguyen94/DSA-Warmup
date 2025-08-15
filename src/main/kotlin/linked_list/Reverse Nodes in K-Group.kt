package linked_list


/**
 * Reverse Nodes in K-Group
 * You are given the head of a singly linked list head and a positive integer k.
 *
 * You must reverse the first k nodes in the linked list, and then reverse the next k nodes, and so on. If there are fewer than k nodes left, leave the nodes as they are.
 *
 * Return the modified list after reversing the nodes in each group of k.
 *
 * You are only allowed to modify the nodes' next pointers, not the values of the nodes.
 */


fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    var cur = head
    var group = 0

    while (cur != null && group < k) {
        cur = cur.next
        group++
    }

    return if (group == k) {
        cur = reverseKGroup(cur, k)
        var tempHead = head

        while (group > 0) {
            val tmp = tempHead!!.next
            tempHead.next = cur
            cur = tempHead
            tempHead = tmp
            group--
        }
        cur
    } else {
        head
    }
}