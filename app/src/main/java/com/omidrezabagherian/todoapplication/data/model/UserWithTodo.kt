package com.omidrezabagherian.todoapplication.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithTodo(
    @Embedded val user: User,
    @Relation(
        parentColumn = "username",
        entityColumn = "userCreated"
    )
    val todo: MutableList<Todo>
)
