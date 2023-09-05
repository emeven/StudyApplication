package com.example.studyapplication.porsche

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.studyapplication.Greeting
import com.example.studyapplication.ui.theme.StudyApplicationTheme
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.dsl.module

class PorscheActivity : ComponentActivity() {

    val appModule = module {
        factory {
            ApiClient()
        }
    }
//    var apiClient: ApiClient = get()
    var msf: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Porsche & Even")
                }
            }
        }
    }

    @Composable
    fun showModelList(modifier: Modifier = Modifier) {
        val l = msf.collectAsState().value
        LazyColumn(Modifier.fillMaxSize()) {
            items(l) {
                ListItem(it)
            }
        }
    }

    @Composable
    fun ListItem(item: String, modifier: Modifier = Modifier) {
        Row(modifier.fillMaxWidth(), horizontalArrangement =
        Arrangement.Center) {
            Text(text = item)
        }
    }
}