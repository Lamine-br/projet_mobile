package com.example.movieexample.services

import com.example.movieexample.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {
    @POST("/users/register")
    fun registerUser(@Body user: User): Call<UserResponse>

    @POST("/users/login")
    fun loginUser(@Body loginData: LoginData): Call<UserResponse>

    data class UserResponse(
        val user: User?,
        val error: String?
    )

    data class LoginData(
        val email: String,
        val password: String
    )
}