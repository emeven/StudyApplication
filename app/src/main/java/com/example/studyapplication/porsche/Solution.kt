package com.example.studyapplication.porsche

import androidx.core.text.isDigitsOnly

/**
 * @author even_p
 * @Date on 2023/9/6 星期三
 * @Description
 */
class Solution {
    fun sort(fileNames: Array<String>): Array<String> {
        val digitRegex = Regex("""\d+|\D+""")
        val array = fileNames.map { name ->
            Pair(name, digitRegex.findAll(name).map {
                it.groupValues.first()
            }.toList())
        }.sortedWith(comparator = { t1, t2 ->
            var pos = 0
            val nameGroup1 = t1.second
            val nameGroup2 = t2.second
            var p1 = nameGroup1[pos]
            var p2 = nameGroup2[pos]
            var result = 0
            while (p1.isNotEmpty() && p2.isNotEmpty() && pos < nameGroup1.size && pos < nameGroup2.size) {
                p1 = nameGroup1[pos]
                p2 = nameGroup2[pos]
                when {
                    p1.isDigitsOnly() && p2.isDigitsOnly() -> {
                        if (p1.toInt() != p2.toInt()) {
                            result = if (p1.toInt() > p2.toInt()) 1 else -1
                            break
                        }
                    }
                    p1 != p2 -> {
                        result = if (p1 > p2) 1 else -1
                        break
                    }
                    else -> {}
                }
                pos++
            }
            if (result == 0) {
                result = if (nameGroup1.size > nameGroup2.size) 1 else -1
            }
            result
        }).map {
            it.first
        }
        return array.toTypedArray()
    }
}