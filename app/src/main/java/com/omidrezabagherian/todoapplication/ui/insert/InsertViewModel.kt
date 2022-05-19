package com.omidrezabagherian.todoapplication.ui.insert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omidrezabagherian.todoapplication.data.TodoRepository
import com.omidrezabagherian.todoapplication.data.model.Todo
import com.omidrezabagherian.todoapplication.data.model.User
import kotlinx.coroutines.launch
import javax.inject.Inject

class InsertViewModel @Inject constructor(private val todoRepository: TodoRepository) :
    ViewModel() {

    fun insertTodo(todo: Todo) {
        viewModelScope.launch {
            todoRepository.insertTodo(todo)
        }
    }

}