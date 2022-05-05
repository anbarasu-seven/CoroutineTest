package com.example.coroutinetest

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class LaunchAsyncViewModel : ViewModel() {

    fun launchWithConcurrentTask() {

        //launch does not return result. it is a fire and forget coroutine.
        val job1 = viewModelScope.launch {
            //starting concurrent job
            async { getResult1() }
            async { getResult2() }
            async { getResult1() }
        }
    }

    fun launchWithSequentialTask() {

        //launch does not return result. it is a fire and forget coroutine.
        val job2 = viewModelScope.launch {
            //starting sequential job
            val result1 = async { getResult1() }.await()
            Log.i("JOB", result1)
            val result2 = async { getResult1() }.await()
            Log.i("JOB", result2)
        }
    }

    fun asyncWithConcurrentTask() {

        //async return result. it is a waiting coroutine.
        val job1 = viewModelScope.async {
            //starting concurrent job
            async { getResult1() }
            async { getResult2() }
            async { getResult1() }

            "COMPLETED"
        }

        //job1.await() return "COMPLETED" as a result
    }

    fun asyncWithSequentialTask() {

        //async return result. it is a waiting coroutine.
        val job2 = viewModelScope.async {
            //starting sequential job
            val async1 = async { getResult1() }
            val result1 = async1.await()
            Log.i("JOB", result1)

            val async2 = async { getResult1() }
            val result2 = async2.await()
            Log.i("JOB", result2)
        }
    }


    private suspend fun getResult1() = withContext(Dispatchers.IO) {
        delay(2000)
        "Result 1"
    }

    private suspend fun getResult2() = withContext(Dispatchers.IO) {
        delay(2000)
        "Result 2"
    }

}