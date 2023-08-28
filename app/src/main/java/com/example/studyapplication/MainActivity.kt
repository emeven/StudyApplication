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
import com.example.studyapplication.utils.EvenUtils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android & Even")
                }
            }
        }

//        val g = intArrayOf(1, 3, 2)
//        val s = intArrayOf(1, 1)

        val g = intArrayOf(1, 2, 5)
        val s = intArrayOf(1, 2, 3, 6, 4, 6)

        val result = GreedyAlgorithm.findContentChildren(g, s)
        EvenUtils.log("result = $result")
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