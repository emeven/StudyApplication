package com.example.studyapplication.porsche

import kotlinx.coroutines.flow.Flow

/**
 * @author even_p
 * @Date on 2023/9/5 星期二
 * @Description
 */
interface ApiClient {
    fun fetchModels(): Flow<List<String>>
}