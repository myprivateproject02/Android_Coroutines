package com.example.androidcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.widget.Toast
import com.example.androidcoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.download.setOnClickListener { view ->
            // If  you not launch with coroutine then download() is running on main/ui thread  so may be ui is lagging
            CoroutineScope(Dispatchers.IO).launch {
                download()
            }

        }

        binding.add.setOnClickListener { view ->
            binding.textView.text = count++.toString()
        }


    }


    private fun download() {
        for (i in 1..200000) {
            Log.e(TAG, "Count is $i in ${Thread.currentThread().name}")
        }
    }


}