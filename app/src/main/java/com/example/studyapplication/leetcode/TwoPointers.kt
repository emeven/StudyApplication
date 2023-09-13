package com.example.studyapplication.leetcode

import com.example.studyapplication.leetcode.entities.ListNode
import com.example.studyapplication.utils.log
import kotlin.math.roundToInt
import kotlin.math.roundToLong
import kotlin.math.sign
import kotlin.math.sqrt

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

    /**
     * LeetCode #633 medium
     * Two Sum
     * https://leetcode.com/problems/sum-of-square-numbers/
     */
    fun judgeSquareSum(c: Int): Boolean {
        var a = 0
        var b = (sqrt(c.toFloat())).toInt()
        while (a <= b) {
            // 用减法代替求和，避免 a^2 + b^2 > Integer.MAX_VALUE
            when ((c - a * a - b * b).sign) {
                -1 -> b--
                1 -> a++
                0 -> {
                    log("a = $a, b = $b")
                    return true
                }
            }
        }
        return false
    }

    /**
     * LeetCode #88 easy
     * 归并两个有序数组
     * https://leetcode.com/problems/merge-sorted-array/
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var pos = nums1.size - 1
        var mp = m - 1
        var np = n - 1
        while (mp >= 0 && np >= 0) {
            nums1[pos--] = if (nums1[mp] > nums2[np]) nums1[mp--] else nums2[np--]
        }
        while (np >= 0) {
            nums1[pos--] = nums2[np--]
        }
    }

    /**
     * LeetCode #142 medium
     * 快慢指针
     * https://leetcode.com/problems/linked-list-cycle-ii/
     */
    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head ?: return null
        var fast = head ?: return null
        // check if there is any cycle
        do {
            if (fast.next == null) return null
            fast = (fast.next)?.next ?: return null
            slow = slow.next ?: return null
        } while (slow != fast)
        // find the cycle begins
        fast = head
        while (fast != slow) {
            slow = slow.next ?: return null
            fast = fast.next ?: return null
        }
        return fast
    }

    /**
     * LeetCode #76 hard
     * 滑动窗口
     * https://leetcode.com/problems/minimum-window-substring/
     */
    fun minWindow(s: String, t: String): String {
        val chars = IntArray(128) { 0 }
        val flags = BooleanArray(128) { false }
        // 统计 t 的字符情况
        t.forEach {
            flags[it.code] = true
            chars[it.code]++
        }
        // 移动滑动窗口 不断更改统计数据
        var count = 0
        var left = 0
        var minLeft = 0
        var minSize = s.length + 1
        s.forEachIndexed { right, c ->
            log("right = $right")
            if (flags[c.code]) {
                if (--chars[c.code] >= 0) {
                    count++
                    log("chars[$c] = ${chars[c.code]}, count = $count")
                }
                // 若目前滑动窗口已包含T中的全部字符
                // 则尝试将 left 右移，在不影响结果的情况下获得最短子字符串
                while (count == t.length) {
                    if (right - left + 1 < minSize) {
                        minLeft = left
                        minSize = right - left + 1
                        log("minLeft = $minLeft, minSize = $minSize")
                    }
                    if (flags[s[left].code] && ++chars[s[left].code] > 0) {
                        count--
                        log("chars[${s[left]}] = ${chars[s[left].code]}, count = $count")
                    } else {
                        log("chars[${s[left]}] = ${chars[s[left].code]}")
                    }
                    left++
                    log("left = $left")
                }
            }
        }
        log("length = ${s.length}, minSize = $minSize, minLeft = $minLeft")
        return if (minSize > s.length) "" else s.substring(minLeft, minLeft + minSize)
    }
}