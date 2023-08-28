package com.example.studyapplication.leetcode

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
}