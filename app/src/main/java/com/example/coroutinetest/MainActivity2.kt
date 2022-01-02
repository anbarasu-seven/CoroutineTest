package com.example.coroutinetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        findViewById<Button>(R.id.button1).setOnClickListener {
            val job = GlobalScope.launch {
                for (i in 0..1000){
                    delay(1000)
                    Log.e("GlobalScope $i", "Running...")
                }
            }

        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            val job = lifecycleScope.launch {
                for (i in 0..1000){
                    delay(1000)
                    Log.e("lifecycleScope $i", "Running...")
                }
            }
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
                myViewModel.fetchData()
        }

    }


}