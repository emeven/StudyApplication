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
     * 分配问题
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
     * 分配问题
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
     * 区间问题
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
     * 分配问题
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

    /**
     * LeetCode #452 medium
     * 区间问题
     * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
     */
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.size == 1) return 1
        points.sortBy { it[1] }
        var count = 1
        var previous = points[0][1]
        points.forEachIndexed { i, point ->
            if (i == 0) return@forEachIndexed
            if (point[0] > previous) {
                count++
                previous = point[1]
            }
        }
        return count
    }

    /**
     * LeetCode #763 medium
     * 区间问题
     * https://leetcode.com/problems/partition-labels/
     */
    fun partitionLabels(s: String): List<Int> {
        val map = HashMap<Char, Int>()
        s.forEachIndexed { index, c ->
            map[c] = index
        }
        val count = ArrayList<Int>()
        var start = -1
        var end = 0
        s.forEachIndexed { index, c ->
            end = maxOf(end, map[c] ?: 0)
            if (end == index) {
                count.add(end - start)
                start = end
                log("index = $index, $count")
            }
        }
        return count
    }

    /**
     * LeetCode #122 medium
     * 区间问题
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     */
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        prices.forEachIndexed { i, price ->
            if (i == 0) return@forEachIndexed
            if (price > prices[i - 1]) {
                profit += price - prices[i - 1]
            }
        }
        return profit
    }

    /**
     * LeetCode #406 medium
     * 区间问题
     * https://leetcode.com/problems/queue-reconstruction-by-height/
     * 参考 https://leetcode.com/problems/queue-reconstruction-by-height/solutions/3720029/sorting-and-insertion/
     */
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(compareBy({ -it[0] }, { it[1] }))
        return mutableListOf<IntArray>().apply {
            people.forEach { person ->
                add(person[1], person)
            }
        }.toTypedArray()
    }

    /**
     * LeetCode #665 medium
     * 区间问题
     * https://leetcode.com/problems/non-decreasing-array/
     */
    fun checkPossibility(nums: IntArray): Boolean {
        if (nums.size < 3) return true
        var isModify = false
        for (i in 1 until nums.size - 1) {
            if (nums[i - 1] <= nums[i] && nums[i] <= nums[i + 1]) {
                // do nothing
            } else {
                if (isModify) return false
                when {
                    nums[i - 1] <= nums[i + 1] -> {
                        nums[i] = nums[i - 1]
                    }
                    nums[i] <= nums[i + 1] -> {
                        nums[i - 1] = nums[i]
                    }
                    nums[i - 1] <= nums[i] -> {
                        nums[i + 1] = nums[i]
                    }
                    else -> {
                        return false
                    }
                }
                isModify = true
            }
        }
        return true
    }
}