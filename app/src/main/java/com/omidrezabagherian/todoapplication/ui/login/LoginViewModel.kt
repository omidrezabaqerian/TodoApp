package com.omidrezabagherian.todoapplication.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omidrezabagherian.todoapplication.data.TodoRepository
import com.omidrezabagherian.todoapplication.data.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val _checkUsernameLogin = MutableStateFlow<User?>(null)
    val checkUsernameLogin: StateFlow<User?> = _checkUsernameLogin

    fun checkLogin(username: String, password: String) {
        viewModelScope.launch {
            todoRepository.checkLogin(username, password).collect {
                _checkUsernameLogin.emit(it)
            }
        }
    }
}