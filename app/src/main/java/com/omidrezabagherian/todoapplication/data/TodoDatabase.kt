package com.omidrezabagherian.todoapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.omidrezabagherian.todoapplication.data.local.TodoDao
import com.omidrezabagherian.todoapplication.data.local.UserDao
import com.omidrezabagherian.todoapplication.data.model.Todo
import com.omidrezabagherian.todoapplication.data.model.User

@Database(entities = [User::class, Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun todoDao(): TodoDao
}