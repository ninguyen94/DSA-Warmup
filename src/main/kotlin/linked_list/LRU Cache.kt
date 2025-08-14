package linked_list

import kotlin.math.abs

/**
LRU Cache

Implement the Least Recently Used (LRU) cache class LRUCache. The class should support the following operations

LRUCache(int capacity) Initialize the LRU cache of size capacity.
int get(int key) Return the value corresponding to the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the introduction of the new pair causes the cache to exceed its capacity, remove the least recently used key.
A key is considered used if a get or a put operation is called on it.

Ensure that get and put each run in
O(1) average time complexity.*/
class LRUCache(capacity: Int) {
    private val capacity = capacity
    private val map = mutableMapOf<Int, Node>()

    class Node(
        val key: Int, var value: Int, var next: Node? = null, var pre: Node? = null
    )

    var head = Node(0, 0)
    var tail = Node(0, 0)

    init {
        head.next = tail
        tail.pre = head
    }

    fun remove(node: Node) {
        val pre = node.pre
        val next = node.next
        pre?.next = next
        next?.pre = pre
    }

    fun insert(node: Node) {
        val pre = tail.pre
        pre?.next = node
        node.pre = pre
        node.next = tail
        tail.pre = node
    }

    fun get(key: Int): Int {
        return map[key]?.let { it ->
            remove(it)
            insert(it)
            it.value
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            map[key]?.let {
                remove(it)
                it.value = value
                insert(it)
            }
        } else {
            val newNode = Node(key, value)
            insert(newNode)
            map[key] = newNode
        }

        if (map.size > capacity) {
            head.next?.let { lru ->
                remove(lru)
                map.remove(lru.key)
            }
        }
    }

}





