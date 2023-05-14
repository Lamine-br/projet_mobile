package com.example.movieexample
import com.example.movieexample.services.RestaurantApiService
import com.example.movieexample.services.UserApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class RetrofitInstance {
    private val BASE_URL = "https://example-6q27.onrender.com/api/v1/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val restaurantApiService: RestaurantApiService by lazy {
        retrofit.create(RestaurantApiService::class.java)
    }

    val userApiService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}