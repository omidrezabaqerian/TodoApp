package com.omidrezabagherian.todoapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey val username: String,
    val firstname: String,
    val lastname: String,
    val password: String,
    val wordSecurity: String
)
