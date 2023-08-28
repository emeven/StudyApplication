package com.example.studyapplication.utils

import android.os.Process
import android.util.Log
import java.lang.StringBuilder

/**
 * @author even_p
 * @Date on 2023/8/28 星期一
 * @Description 工具类
 */
fun log(msg: String) {
    Log.d("even_p_${Process.myPid()}", msg)
}

fun IntArray.toArrayString(): String {
    val string = StringBuilder("[")
    this.forEachIndexed { index, i ->
        if (index == this.size -1) {
            string.append(i)
        } else {
            string.append("$i, ")
        }
    }
    string.append(']')
    return string.toString()
}