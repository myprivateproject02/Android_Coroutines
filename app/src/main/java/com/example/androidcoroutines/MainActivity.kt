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
    lateinit var job: Job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        job = CoroutineScope(Dispatchers.Main).launch {
            downloadData()
        }

        binding.cancelButton.setOnClickListener {
            job.cancel()
        }


        binding.checkState.setOnClickListener {
            if(job.isActive){
                binding.status.text = "Active"
            }else if(job.isCancelled){
                binding.status.text ="Cancelled"
            }else if(job.isCompleted){
                binding.status.text = "Completed"
            }
        }


    }


    private suspend fun downloadData(){
        withContext(Dispatchers.IO){
            repeat(30){
                delay(1000)
                Log.e(TAG, "DownloadData: $it")
            }
        }
    }



}