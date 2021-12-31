package com.example.coroutinetest

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    fun fetchData() {
        viewModelScope.launch {
            for (i in 1..1000) {
                delay(1000)
                Log.i("viewModelScope $i",Thread.currentThread().name.toString())
            }
        }
    }

}