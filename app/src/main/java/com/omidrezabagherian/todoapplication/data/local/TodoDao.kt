package com.omidrezabagherian.todoapplication.data.local

import androidx.room.*
import com.omidrezabagherian.todoapplication.data.model.Part
import com.omidrezabagherian.todoapplication.data.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodo(todo: Todo)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateTodo(todo: Todo)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM todo_table WHERE part=:partInput")
    fun checkPart(partInput: Part): Flow<List<Todo>>

}