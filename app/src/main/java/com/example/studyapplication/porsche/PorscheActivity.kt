package com.example.studyapplication.porsche

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.studyapplication.ui.theme.StudyApplicationTheme
import com.example.studyapplication.utils.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class PorscheActivity : ComponentActivity() {

//    var apiClient: ApiClient = get()
//    var msf: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    // apiClient & msf should be private
    private val myModel: MyModel = get()
    private val msf: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("PorscheActivity start")
        setContent {
            StudyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    showModelList()
                }
            }
        }

//        fetchModels()
//        test()
        sort()
    }

    private fun sort() {
//        val input = arrayOf(
//            "file2.gif",
//            "file01.gif",
//            "1file.jpg",
//            "1file.gif",
//            "file10.gif",
//            "file1.gif",
//            "file1a.gif"
//        )

        val input = arrayOf(
            "1file.png",
            "file10.gif",
            "file2.gif"
        )

        "1f.Aacd".forEach {
            log("$it code = ${it.code}")
        }
        Solution().sort(input).forEach {
            log(it)
        }
    }

    private fun fetchModels() {
        // lifecycleScope is better
        lifecycleScope.launch {
            log("${currentCoroutineContext()} lifecycleScope launch")
            myModel
                .fetchModels(this)
                .flowOn(Dispatchers.IO)
                .catch {
                    log("Failed to get list of car models.")
                    Log.e("MainViewModel", "Failed to get list of car models.")
                }
                .collect {
                    log("${currentCoroutineContext()} collect")
                    msf.value = it
                }
        }
    }

    fun test() {
        lifecycleScope.launch {
            log("${currentCoroutineContext()} lifecycleScope launch")
            flow {
                for (i in 1..3) {
                    log("flow :${currentCoroutineContext()}")
                    delay(100)
                    emit(i)
                }
            }.flowOn(Dispatchers.IO)
                .collect { value ->
                    log("collect:${currentCoroutineContext()} value :${value}")
                }
        }
    }

    @Composable
    // modifier should be deleted for it is never used
    fun showModelList(modifier: Modifier = Modifier) {
        val l = msf.collectAsState().value
        log("showModelList, list size = ${l.size}")
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

    companion object {
        fun start(activity: Context) {
            val intent = Intent(activity, PorscheActivity::class.java)
            activity.startActivity(intent)
        }
    }
}