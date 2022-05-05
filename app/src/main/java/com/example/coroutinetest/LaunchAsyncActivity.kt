package com.example.coroutinetest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class LaunchAsyncActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val myViewModel: LaunchAsyncViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_and_async)


        findViewById<Button>(R.id.button1).setOnClickListener {
            myViewModel.fetchDataUsingLaunch()
        }

        //activity scoped job
        findViewById<Button>(R.id.button2).setOnClickListener {
            myViewModel.fetchDataUsingAsync()

        }
    }


}