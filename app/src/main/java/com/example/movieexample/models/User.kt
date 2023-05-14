package com.example.movieexample.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class User (
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("createdAt") val createdAt: Date,
)