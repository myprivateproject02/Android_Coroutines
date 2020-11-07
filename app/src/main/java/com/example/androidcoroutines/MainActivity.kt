package com.example.androidcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.widget.Toast
import com.example.androidcoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var suspendDemo = SuspendDemo2()
        binding.download.setOnClickListener { view ->
            // If  you not launch with coroutine then download() is running on main/ui thread  so may be ui is lagging

            CoroutineScope(IO).launch {
                var stock1 = getStock1()
                var stock2 = getStock2()
                val total = stock1 + stock2
                Log.e("Stock", "onCreate: " + total)
            }
        }

    }


    suspend fun getStock1(): Int {
        delay(1000)
        Log.e(TAG, "getStock1: ")
        return 2000

    }

    suspend fun getStock2(): Int {
        delay(5000)
        Log.e(TAG, "getStock2: ")
        return 5000
    }


}