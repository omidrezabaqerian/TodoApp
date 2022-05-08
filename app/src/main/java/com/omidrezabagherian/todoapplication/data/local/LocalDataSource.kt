package com.omidrezabagherian.todoapplication.data.local

import com.omidrezabagherian.todoapplication.data.model.Part
import com.omidrezabagherian.todoapplication.data.model.Todo
import com.omidrezabagherian.todoapplication.data.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val userDao: UserDao,
    private val todoDao: TodoDao,
) {
    suspend fun insertRegister(user: User) {
        userDao.insertRegister(user)
    }

    suspend fun updateRegister(user: User) {
        userDao.updateRegister(user)
    }

    suspend fun deleteRegister(user: User) {
        userDao.deleteRegister(user)
    }

    fun checkUsername(username: String): Flow<User> {
        return userDao.checkUsername(username)
    }

    fun checkLogin(username: String, password: String): Flow<User> {
        return userDao.checkLogin(username, password)
    }

    fun checkForget(
        firstname: String,
        lastname: String,
        wordSecurity: String
    ): Flow<User> {
        return checkForget(firstname, lastname, wordSecurity)
    }

    suspend fun insertTodo(todo: Todo) {
        todoDao.insertTodo(todo)
    }

    suspend fun updateTodo(todo: Todo) {
        todoDao.updateTodo(todo)
    }

    suspend fun deleteAllTodo() {
        todoDao.deleteAllTodo()
    }

    suspend fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(todo)
    }

    fun checkPart(part: Part): Flow<List<Todo>> {
        return todoDao.checkPart(part)
    }

}