package com.example.androidcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.widget.Toast
import com.example.androidcoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        CoroutineScope(Dispatchers.Main).launch {
            binding.status.text = UserDataManager().getTotalUserCount().toString()
        }

    }


}