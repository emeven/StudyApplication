package com.example.studyapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.studyapplication.leetcode.GreedyAlgorithm
import com.example.studyapplication.leetcode.TwoPointers
import com.example.studyapplication.leetcode.entities.ListNode
import com.example.studyapplication.porsche.PorscheActivity
import com.example.studyapplication.ui.theme.StudyApplicationTheme
import com.example.studyapplication.utils.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android & Even") {
                        PorscheActivity.start(this)
                    }
                }
            }
        }

        twoPointers()
    }

    private fun eraseOverlapIntervals() {
//        val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 3))
//        val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 2))
        val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        val result = GreedyAlgorithm.eraseOverlapIntervals(intervals)
        log("result = $result")
    }

    private fun canPlaceFlowers() {
//        val flowerbed = intArrayOf(1, 0, 0, 0, 1)
//        val flowerbed = intArrayOf(0,0,0,1,0,0)
        val flowerbed = intArrayOf(0, 0, 1, 0, 1, 0, 0, 0, 0, 1)
        val n = 1
        val result = GreedyAlgorithm.canPlaceFlowers(flowerbed, n)
        log("____result = $result ___")
    }

    private fun findMinArrowShots() {
        // testcase
        // [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
        val point = arrayOf(intArrayOf(3, 9), intArrayOf(7, 12), intArrayOf(3, 8), intArrayOf(6, 8), intArrayOf(9, 10), intArrayOf(6, 8))
        val result = GreedyAlgorithm.findMinArrowShots(point)
        log("____result = $result ___")
    }

    private fun partitionLabels() {
        val s = "ababcbacadefegdehijhklij"
        val result = GreedyAlgorithm.partitionLabels(s)
        log("____result = $result ____")
    }

    private fun maxProfit() {
        val prices = intArrayOf(1,2,3,4,5)
        val result = GreedyAlgorithm.maxProfit(prices)
        log("____result = $result ____")
    }

    private fun reconstructQueue() {
        val people = arrayOf(
            intArrayOf(9, 0),
            intArrayOf(7, 0),
            intArrayOf(1, 9),
            intArrayOf(3, 0),
            intArrayOf(2, 7),
            intArrayOf(5, 3),
            intArrayOf(6, 0),
            intArrayOf(3, 4),
            intArrayOf(6, 2),
            intArrayOf(5, 2)
        )
        val result = GreedyAlgorithm.reconstructQueue(people)
        log("____result = $result ____")
    }

    private fun checkPossibility() {
//        val nums = intArrayOf(0, 4, 9, 10, 3, 4, 11)
//        val nums = intArrayOf(-1, 4, 2, 3)
//        val nums = intArrayOf(4, 2, 3)
        val nums = intArrayOf(4, 2, 1)
        val result = GreedyAlgorithm.checkPossibility(nums)
        log("____result = $result ____")
    }

    /**
     * 双指针
     */
    private fun twoPointers() {
//        twoSum()
//        judgeSquareSum()
        validPalindrome()
//        merge()
//        detectCycle()
//        minWindow()
    }

    private fun twoSum() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val result = TwoPointers.twoSum(nums, target)
        log("____result = $result ____")
    }

    private fun judgeSquareSum() {
        val c = 2147483600
        val result = TwoPointers.judgeSquareSum(c)
        log("____result = $result ____")
    }

    private fun validPalindrome() {
        val s = "abc"
        val result = TwoPointers.validPalindrome(s)
        log("____result = $result ____")
    }

    private fun merge() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val m = 3
        val nums2 = intArrayOf(2, 5, 6)
        val n = 3
        TwoPointers.merge(nums1, m, nums2, n)
    }

    private fun detectCycle() {
        val head = ListNode(3)
        val node1 = ListNode(2)
        val node2 = ListNode(0)
        val node3 = ListNode(-4)
        head.next = node1
        node1.next = node2
        node2.next = node3
        node3.next = node1
        TwoPointers.detectCycle(head)
    }

    private fun minWindow() {
//        val s = "ADOBECODEBANC"
//        val t = "ABC"
        val s = "a"
        val t = "aa"
        val result = TwoPointers.minWindow(s, t)
        log("____result = $result ____")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, action: () -> Unit = {}) {
    Text(
        text = "Hello $name!",
        modifier = modifier.clickable {
            action.invoke()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StudyApplicationTheme {
        Greeting("Android")
    }
}