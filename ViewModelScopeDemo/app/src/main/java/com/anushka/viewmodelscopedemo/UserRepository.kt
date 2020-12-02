package com.anushka.viewmodelscopedemo

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers(): List<User> {
        delay(8000)
        val users: List<User> = listOf(
            User(1, "Sam"),
            User(1, "Taro"),
            User(1, "Jane"),
            User(1, "Amy")
            )
        return users
    }
}