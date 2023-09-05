package com.example.studyapplication

import android.app.Application
import org.koin.core.context.startKoin

/**
 * @author even_p
 * @Date on 2023/9/5 星期二
 * @Description
 */
class StudyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {

        }
    }
}