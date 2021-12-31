package com.example.coroutinetest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    //private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button1).setOnClickListener {
            Threading.fakeNetworkRequest()
        }














        /*findViewById<Button>(R.id.button2).setOnClickListener {
            val job = lifecycleScope.launch {
                for (i in 1..1000) {
                    delay(1000)
                    Log.i("lifecycleScope $i",Thread.currentThread().name.toString())
                }
            }
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            myViewModel.fetchData()
        }

        findViewById<Button>(R.id.button5).setOnClickListener {
            GlobalScope.launch{
                for (i in 1..1000) {
                    GlobalScope.launch(Dispatchers.IO) {
                        val result = 100 * 100 / 200 + 45
                        delay(1000)
                        Log.i("Dispatchers.IO $i", Thread.currentThread().name.toString())
                    }
                }
            }
        }

        findViewById<Button>(R.id.button6).setOnClickListener {
            GlobalScope.launch{
                for (i in 1..1000) {
                    GlobalScope.launch(Dispatchers.Main) {
                        val result = 100 * 100 / 200 + 45
                        delay(1000)
                        Log.i("Dispatchers.Main $i", Thread.currentThread().name.toString())
                    }
                }
            }
        }

        findViewById<Button>(R.id.button7).setOnClickListener {
            GlobalScope.launch{
                for (i in 1..1000) {
                    GlobalScope.launch(Dispatchers.Default) {
                        val result = 100 * 100 / 200 + 45
                        delay(1000)
                        Log.i("Dispatchers.Default $i", Thread.currentThread().name.toString())
                    }
                }
            }
        }

        findViewById<Button>(R.id.button8).setOnClickListener {
            GlobalScope.launch{
                for (i in 1..1000) {
                    GlobalScope.launch(Dispatchers.Unconfined) {
                        val result = 100 * 100 / 200 + 45
                        delay(1000)
                        Log.i("Dispatchers.Unconfined $i", Thread.currentThread().name.toString())
                    }
                }
            }
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

        /*findViewById<Button>(R.id.textViewId).setOnClickListener {
            GlobalScope.launch {
                delay(2000)
                for (i in 1..1000) {
                    GlobalScope.launch(Dispatchers.Unconfined) {
                        Log.i("Main $i",Thread.currentThread().name.toString())
                    }
                }
            }
        }

        conclusion
        default dispatcher - 8 worker threads
        IO dispatchers - 16 worker thread
        MAIN dispatcher - 1 thread, ie UI thread
        Unconfined - 1 worker thread
        */*/

    }

}