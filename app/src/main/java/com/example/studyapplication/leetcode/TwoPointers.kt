package com.example.studyapplication.leetcode

import com.example.studyapplication.leetcode.entities.ListNode
import com.example.studyapplication.utils.log
import com.example.studyapplication.utils.toArrayString

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
}