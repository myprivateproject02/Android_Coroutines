package com.example.androidcoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class MainViewModel : ViewModel() {

    private val mainRepo = MainRepository()
    var users: MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData() {
        viewModelScope.launch {
            var result: List<User>? = null
            withContext(IO) {
                result = mainRepo.getUsers()
            }
            users.value = result
        }
    }
}