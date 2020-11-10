package com.example.androidcoroutines

import kotlinx.coroutines.delay

class MainRepo {

    suspend fun getUsers(): List<User> {
        val users: List<User> = listOf(
            User(1, "Rupesh"),
            User(2, "Rohit"),
            User(3, "Kapesh"),
            User(4, "Akshay"),
            User(5, "Sagar"),
        )

        return users
    }
}