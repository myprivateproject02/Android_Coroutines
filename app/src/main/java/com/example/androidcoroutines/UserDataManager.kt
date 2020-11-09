package com.example.androidcoroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserDataManager {

    suspend fun getTotalUserData(): Int {
        var coutn: Int = 0

        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            coutn = 50
        }

        val deffered = CoroutineScope(IO).async {
            delay(3000)
            return@async 70
        }
        return coutn + deffered.await()
    }


}