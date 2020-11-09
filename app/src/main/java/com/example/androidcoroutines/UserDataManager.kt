package com.example.androidcoroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserDataManager {

    var count = 0
    lateinit var deferred: Deferred<Int>

    suspend fun getTotalUserCount(): Int {

        coroutineScope {
            launch(Dispatchers.IO) {
                delay(2000)
                count = 50
            }

            deferred = async {
                delay(5000)
                return@async 70
            }

        }

        return count + deferred.await()
    }


}