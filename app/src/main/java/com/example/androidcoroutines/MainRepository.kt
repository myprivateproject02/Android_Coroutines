package com.example.androidcoroutines

import kotlinx.coroutines.delay

class MainRepository {

    suspend fun getUsers(): List<User> {
        delay(8000)
        val user: List<User> = listOf(
            User(1, "Rupesh"),
            User(2, "Rohit"),
            User(3, "Kalspesh"),
            User(4, "Hrutik"),
        )
        return user
    }

}