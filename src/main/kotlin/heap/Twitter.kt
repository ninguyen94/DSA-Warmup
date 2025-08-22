package heap

import java.util.PriorityQueue


/*+
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/
/**
 * bucket sort
 */
fun main() {
    val twitter = Twitter()
    twitter.postTweet(1, 5)
    twitter.postTweet(1, 3)
    val tweet = twitter.getNewsFeed(1)
    println(tweet)
}

class Twitter() {
    val tweetMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    val followMap = mutableMapOf<Int, HashSet<Int>>()
    var timestamp = 0

    fun postTweet(userId: Int, tweetId: Int) {
        timestamp++
        tweetMap.getOrPut(userId) { mutableListOf() }.add(tweetId to timestamp)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val users = followMap[userId] ?: mutableListOf(userId)

        val tweets = mutableListOf<Pair<Int, Int>>()

        users.forEach { userID ->
            tweetMap[userID]?.let { tweets.addAll(it) }
        }

        val recentPost = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
        tweets.forEach {
            recentPost.add(it)
        }

        val res = mutableListOf<Int>()
        while (recentPost.isNotEmpty()) {
            val tweet = recentPost.poll()
            res.add(tweet.first)
            if (res.size >= 10) break
        }

        return res
    }

    fun follow(followerId: Int, followeeId: Int) {
        followMap.getOrPut(followerId, { hashSetOf(followerId) }).add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        followMap[followerId]?.remove(followeeId)
    }

}