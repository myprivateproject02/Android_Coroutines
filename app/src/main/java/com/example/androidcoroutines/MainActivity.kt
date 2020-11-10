package com.example.androidcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.androidcoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        lifecycleScope.launch(Dispatchers.IO) {
            Log.e(TAG, "onActivityCreated: ${Thread.currentThread().name}")
        }

        lifecycleScope.launch(Dispatchers.IO) {
            Log.e(TAG, "onActivityCreated: ${Thread.currentThread().name}")
        }

        lifecycleScope.launchWhenCreated {
            Log.e(TAG, "onActivityCreated2: ${Thread.currentThread().name}")
        }
        lifecycleScope.launchWhenStarted {
            Log.e(TAG, "onActivityCreated3: ${Thread.currentThread().name}")
        }

        lifecycleScope.launchWhenResumed {
            Log.e(TAG, "onActivityCreated4: ${Thread.currentThread().name}")
        }

    }

}