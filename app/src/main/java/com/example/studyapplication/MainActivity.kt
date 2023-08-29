package com.example.studyapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.studyapplication.leetcode.GreedyAlgorithm
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
                    Greeting("Android & Even")
                }
            }
        }

//        val g = intArrayOf(1, 3, 2)
//        val s = intArrayOf(1, 1)

        val g = intArrayOf(1, 2, 5)
        val s = intArrayOf(1, 2, 3, 6, 4, 6)

        val result_455 = GreedyAlgorithm.findContentChildren(g, s)

//        val ratings = intArrayOf(1, 2, 2) // 4
//        val ratings = intArrayOf(1, 3, 2, 2, 1) // 7
        val ratings = intArrayOf(1, 3, 2, 7, 1, 4, 4, 5, 6, 0)
        // [1, 2, 1, 2, 1, 2, 1, 2, 3, 1] result = 16
//        val result_135 = GreedyAlgorithm.candy(ratings)
//        canPlaceFlowers()

        // 区间问题
//        eraseOverlapIntervals()
//        findMinArrowShots()
//        partitionLabels()
//        maxProfit()
        reconstructQueue()
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
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StudyApplicationTheme {
        Greeting("Android")
    }
}