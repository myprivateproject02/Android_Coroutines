package com.example.androidcoroutines

import android.util.Log
import kotlinx.coroutines.delay

public class SuspendDemo2() {

    private  val TAG = "Stock"

    suspend fun getStock1(): Int {
        delay(1000)
        Log.e(TAG, "getStock1: ${System.currentTimeMillis()}", )
        return 2000

    }

    public suspend fun getStock2(): Int {
        delay(3000)
        Log.e(TAG, "getStock2: ${System.currentTimeMillis()}", )
        return 7000
    }

}