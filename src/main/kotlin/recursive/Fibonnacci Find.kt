package recursive


val cache = mutableMapOf<Int, Int>()
fun fibonnaciFind(n: Int): Int {
    if (n < 2) return n

    if (cache.contains(n)) {
        return cache[n]!!
    }
    cache[n] = fibonnaciFind(n - 1) + fibonnaciFind(n - 2)

    return cache[n]!!
}