package com.example.studyapplication.leetcode

import com.example.studyapplication.utils.log
import com.example.studyapplication.utils.toArrayString

/**
 * @author even_p
 * @Date on 2023/8/27 星期日
 * @Description 贪心算法
 */
object GreedyAlgorithm {
    /**
     * LeetCode #455 easy
     * https://leetcode.com/problems/assign-cookies/
     */
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        var cookie = 0
        var child = 0

        while (cookie < s.size && child < g.size) {
            if (g[child] <= s[cookie]) child++
            cookie++
        }
        return child
    }

    /**
     * LeetCode #135 hard
     * https://leetcode.com/problems/candy/
     */
    fun candy(ratings: IntArray): Int {
        if (ratings.size < 2) {
            return ratings.size
        }
        val candies = IntArray(ratings.size) { 1 }
        for (i in 0 until ratings.size - 1) {
            if (ratings[i] < ratings[i + 1]) {
                candies[i + 1] = candies[i] + 1
            }
        }
        for (i in ratings.size - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = maxOf(candies[i], candies[i + 1] + 1)
            }
        }
        log("candies = ${candies.toArrayString()}")
        return candies.sum()
    }

    /**
     * LeetCode #435 medium
     * https://leetcode.com/problems/non-overlapping-intervals/
     */
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.size < 2) return 0
        intervals.sortBy { it[1] }
        var count = 0
        var previous = intervals[0][1]
        intervals.forEachIndexed { index, interval ->
            if (index == 0) return@forEachIndexed
            if (interval[0] < previous) {
                log("remove ${interval.toArrayString()}")
                count++
            } else {
                previous = interval[1]
            }
        }
        return count
    }

    /**
     * LeetCode #605 easy
     * https://leetcode.com/problems/can-place-flowers/
     */
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        log("init flowerbed = ${flowerbed.toArrayString()}")
        if (n == 0) return true
        var count = n
        flowerbed.forEachIndexed { i, plant ->
            if (plant == 0
                && (i == 0 || flowerbed[i - 1] == 0)
                && (i == flowerbed.size - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1
//                if (--count == 0) return true
                count--
            }
        }
        log("last flowerbed = ${flowerbed.toArrayString()}")
        return count <= 0
    }
}