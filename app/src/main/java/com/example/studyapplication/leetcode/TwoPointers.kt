package com.example.studyapplication.leetcode

import com.example.studyapplication.utils.log

/**
 * @author even_p
 * @Date on 2023/8/30 星期三
 * @Description 双指针
 */
object TwoPointers {
    /**
     * LeetCode #167 medium
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     */
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1
        while (left < right) {
            val sum = numbers[left] + numbers[right]
            when {
                sum > target -> right--
                sum < target -> left++
                else -> break
            }
        }
        return intArrayOf(++left, ++right)
    }
}