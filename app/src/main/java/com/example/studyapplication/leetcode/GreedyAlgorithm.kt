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
     * LeetCode #455
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
     * LeetCode #135
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
}