package com.omidrezabagherian.todoapplication.di

import android.content.Context
import androidx.room.Room
import com.omidrezabagherian.todoapplication.data.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideUserDatabase(@ApplicationContext userContext: Context) = Room.databaseBuilder(
        userContext,
        TodoDatabase::class.java,
        "todo_database"
    ).build()

    @Singleton
    @Provides
    fun provideUserDao(database: TodoDatabase) = database.userDao()

    @Singleton
    @Provides
    fun provideTodoDao(database: TodoDatabase) = database.todoDao()


}