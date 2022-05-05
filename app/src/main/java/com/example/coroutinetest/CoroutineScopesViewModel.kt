package com.example.coroutinetest

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineScopesViewModel : ViewModel() {

    fun fetchData() {
        val job = viewModelScope.launch {
            for (i in 0..1000){
                delay(1000)
                Log.e("viewModelScope $i", "Running...")
            }
        }
    }

}