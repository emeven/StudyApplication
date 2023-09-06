package com.example.studyapplication.porsche

import com.example.studyapplication.utils.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit

/**
 * @author even_p
 * @Date on 2023/9/5 星期二
 * @Description
 */
class MyModel {

    private val apiClient = Retrofit.Builder()
        .baseUrl("https://base_url")
        .build()
        .create(ApiClient::class.java)

    fun fetchModels(scope: CoroutineScope): Flow<List<String>> {
        log("${scope.coroutineContext} fetchModels")
        val content = listOf(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L"
        )
        return flow {
            log("${scope.coroutineContext} fetchModels-flow")
            delay(100)
            emit(content)
        }
//        return apiClient.fetchModels()
    }
}