package com.omidrezabagherian.todoapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val part: Part,
    val state: State,
    val condition: Condition
)
