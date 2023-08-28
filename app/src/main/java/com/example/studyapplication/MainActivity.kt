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
        val result_135 = GreedyAlgorithm.candy(ratings)

        eraseOverlapIntervals()
    }

    private fun eraseOverlapIntervals() {
//        val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 3))
//        val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 2))
        val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        val result = GreedyAlgorithm.eraseOverlapIntervals(intervals)
        log("result = $result")
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