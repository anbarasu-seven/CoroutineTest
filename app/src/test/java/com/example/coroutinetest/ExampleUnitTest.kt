package com.example.coroutinetest

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        //assertEquals(4, 2 + 2)

        for (i in 1..1000) {
            GlobalScope.launch(Dispatchers.IO) {
                println("Main $i ${Thread.currentThread().name.toString()}")
            }
        }
    }
}