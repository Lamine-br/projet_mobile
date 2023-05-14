package com.example.movieexample.services

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import com.example.movieexample.models.Restaurant as Restaurant1

interface RestaurantApiService {
    // Define your API endpoints here

    @GET("restaurants")
    fun fetchRestaurants(): Call<List<Restaurant1>>

    @POST("restaurants")
    fun postRestaurant(@Body restaurant: Restaurant1): Call<Unit>
}