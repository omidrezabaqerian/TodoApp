package com.omidrezabagherian.todoapplication.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omidrezabagherian.todoapplication.data.TodoRepository
import com.omidrezabagherian.todoapplication.data.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val _checkUsername = MutableStateFlow<User?>(null)
    val checkUsername: StateFlow<User?> = _checkUsername

    fun insertRegister(user: User) {
        viewModelScope.launch {
            todoRepository.insertRegister(user)
        }
    }

    fun checkUsername(username: String) {
        viewModelScope.launch {
            todoRepository.checkUsername(username).collect {
                _checkUsername.emit(it)
            }
        }
    }
}