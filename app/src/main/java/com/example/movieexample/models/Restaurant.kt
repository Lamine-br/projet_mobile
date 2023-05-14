package com.example.movieexample.models

import com.google.gson.annotations.SerializedName

data class Restaurant (
    @SerializedName("nom") val nom: String,
    @SerializedName("description") val description: String,
    @SerializedName("address") val address: String,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("category") val category: String,
    @SerializedName("averageRating") val averageRating: Double,
    @SerializedName("numberOfReviews") val numberOfReviews: Int,
    @SerializedName("phone") val phone: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("facebook") val facebook: String?,
    @SerializedName("numTel") val numTel: String?
)