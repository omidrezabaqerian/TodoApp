package com.omidrezabagherian.todoapplication.data.local

import androidx.room.*
import com.omidrezabagherian.todoapplication.data.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRegister(user: User)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateRegister(user: User)

    @Delete
    suspend fun deleteRegister(user: User)

    @Query("SELECT * FROM user_table WHERE username=:usernameInput")
    fun checkUsername(usernameInput: String): Flow<User>

    @Query("SELECT * FROM user_table WHERE username=:usernameInput AND password=:passwordInput")
    fun checkLogin(usernameInput: String, passwordInput: String): Flow<User>

    @Query("SELECT * FROM user_table WHERE firstname=:firstnameInput AND lastname=:lastnameInput AND wordSecurity=:wordSecurityInput")
    fun checkForget(
        firstnameInput: String,
        lastnameInput: String,
        wordSecurityInput: String
    ): Flow<User>
}