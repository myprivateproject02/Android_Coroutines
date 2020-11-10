package com.example.androidcoroutines

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    val mainRepo = MainRepo()

    var users = liveData(IO) {
        emit(mainRepo.getUsers())
    }


}