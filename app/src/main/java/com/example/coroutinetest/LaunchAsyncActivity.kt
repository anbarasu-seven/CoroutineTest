package com.example.coroutinetest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class LaunchAsyncActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_and_async)

        //application scoped job
        findViewById<Button>(R.id.button1).setOnClickListener {

            for (i in 1..5){
                GlobalScope.launch { getResult1() }
                GlobalScope.launch { getResult1() }
                GlobalScope.launch { getResult1() }

                GlobalScope.launch { getResult2() }
                GlobalScope.launch { getResult2() }
                GlobalScope.launch { getResult2() }
            }

        }

        //activity scoped job
        findViewById<Button>(R.id.button2).setOnClickListener {

            for (i in 1..5){
                GlobalScope.async { getResult1() }
                GlobalScope.async { getResult1() }
                GlobalScope.async { getResult1() }

                GlobalScope.async { getResult2() }
                GlobalScope.async { getResult2() }
                GlobalScope.async { getResult2() }
            }

        }
    }

    private suspend fun getResult1() = withContext(Dispatchers.IO){
        Log.e("JOB", "Result...1")
    }

    private suspend fun getResult2() = withContext(Dispatchers.IO){
        Log.i("JOB", "Result...2")
    }

}