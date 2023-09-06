package com.example.studyapplication

import android.app.Application
import com.example.studyapplication.porsche.MyModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * @author even_p
 * @Date on 2023/9/5 星期二
 * @Description
 */
class StudyMyApplication: Application() {

    private val appModule = module {
        factory {
//            ApiClient()
            // ApiClient is just an interface, it doesn't have a constructor
            MyModel()
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@StudyMyApplication)
            modules(appModule)
        }
    }
}