package binary_search

/**
Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 */
fun main() {
    val timeMap = TimeMap()
    timeMap.set("foo", "bar", 1)
//    timeMap.get("foo", 1)
//    timeMap.get("foo", 3)
    timeMap.set("foo", "bar2", 4)
    print(timeMap.get("foo", 5))
}

class TimeMap() {
    val map = mutableMapOf<String, MutableList<Pair<Int, String>>>()
    fun set(key: String, value: String, timestamp: Int) {
        map.getOrPut(key) { mutableListOf() }.add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        var nearestValue = ""
        val values = map[key]
        if (!values.isNullOrEmpty()) {
            var l = 0
            var r = values.size - 1
            while (l <= r) {
                val m = l + (r - l) / 2
                val cur = values[m].first
                if (cur == timestamp) return values[m].second
                if (timestamp < cur) {
                    r = m - 1
                } else {
                    nearestValue = values[m].second
                    l = m + 1
                }
            }
            return nearestValue
        }
        return nearestValue
    }
}

//    fun findMin(nums: IntArray): Int {
//        var l = 0
//        var r = nums.lastIndex
//        while (l <= r) {
//            if (nums[l] <= nums[r]) {
//                return nums[l]
//            }
//
//            val m = l + (r - l) / 2
//
//            if (nums[l] > nums[m]) {
//                r = m
//            } else l = m + 1
//        }
//        return Int.MIN_VALUE
//    }