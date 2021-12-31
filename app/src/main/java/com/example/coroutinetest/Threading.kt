package com.example.coroutinetest

import android.os.AsyncTask
import android.util.Log

object Threading {

    val TAG: String = Threading::class.java.name

    fun startThread(){
        val thread = Thread(Runnable {
            fakeNetworkRequest()
        })
        thread.start()
    }

    fun startAsyncTask(){

        class ApiAsyncTask: AsyncTask<Int, Unit, Int>(){

            override fun onPreExecute() {
                super.onPreExecute()
            }

            override fun doInBackground(vararg params: Int?): Int {
                TODO("Not yet implemented")
            }

            override fun onPostExecute(result: Int?) {
                super.onPostExecute(result)
            }
        }
    }


    fun fakeNetworkRequest(){
        for(i in 0..100){
            Thread.sleep(1000)
            Log.e(TAG, i.toString())
        }
    }
}