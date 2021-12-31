package com.example.coroutinetest

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ThreadSample : AppCompatActivity() {

    //private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.thread_sample)

        findViewById<Button>(R.id.button1).setOnClickListener {

           val job = GlobalScope.launch(Dispatchers.IO) {
               Threading.fakeNetworkRequest()
           }

        }
    }

}