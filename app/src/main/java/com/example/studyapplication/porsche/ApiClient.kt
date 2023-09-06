package com.example.studyapplication.porsche

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * @author even_p
 * @Date on 2023/9/5 星期二
 * @Description
 */
interface ApiClient {
    // define url
    @GET("todo_url")
    fun fetchModels(): Flow<List<String>>
}