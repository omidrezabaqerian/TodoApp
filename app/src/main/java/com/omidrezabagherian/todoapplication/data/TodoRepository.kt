package com.omidrezabagherian.todoapplication.data

import com.omidrezabagherian.todoapplication.data.local.LocalDataSource
import com.omidrezabagherian.todoapplication.data.model.Part
import com.omidrezabagherian.todoapplication.data.model.Todo
import com.omidrezabagherian.todoapplication.data.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) {
    suspend fun insertRegister(user: User) {
        localDataSource.insertRegister(user)
    }

    suspend fun updateRegister(user: User) {
        localDataSource.updateRegister(user)
    }

    suspend fun deleteRegister(user: User) {
        localDataSource.deleteRegister(user)
    }

    fun checkUsername(username: String): Flow<User> {
        return localDataSource.checkUsername(username)
    }

    fun checkLogin(username: String, password: String): Flow<User> {
        return localDataSource.checkLogin(username, password)
    }

    fun checkForget(
        firstname: String,
        lastname: String,
        wordSecurity: String
    ): Flow<User> {
        return localDataSource.checkForget(firstname, lastname, wordSecurity)
    }

    suspend fun insertTodo(todo: Todo) {
        localDataSource.insertTodo(todo)
    }

    suspend fun updateTodo(todo: Todo) {
        localDataSource.updateTodo(todo)
    }

    suspend fun deleteAllTodo() {
        localDataSource.deleteAllTodo()
    }

    suspend fun deleteTodo(todo: Todo) {
        localDataSource.deleteTodo(todo)
    }

    fun checkPart(part: Part): Flow<List<Todo>> {
        return localDataSource.checkPart(part)
    }

}