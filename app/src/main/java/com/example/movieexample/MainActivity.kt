package com.example.movieexample
import com.example.movieexample.models.Restaurant

import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import com.example.movieexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // List of menus
        val menus = mutableListOf<Menu>()
        val instance = AppDatabase.buildDatabase(this.applicationContext)

        if (instance?.getMenuDao()?.getMenus()?.isEmpty() == true){
            menus.forEach { instance.getMenuDao().addMenu(it) }
        }else{
            for (menu in menus) {
                val dbMenus = AppDatabase.buildDatabase(this)?.getMenuDao()?.getMenus()!!
                val dbMenu = dbMenus.find { it.menuId == menu.menuId }
                if (dbMenu == null) {
                    // menu not in database, add it
                    instance?.getMenuDao()?.addMenu(menu)
                } else if (dbMenu != menu) {
                    // menu in database but different, update it
                    instance?.getMenuDao()?.updateMenu(menu)
                }
            }
        }

        binding.cart.setOnClickListener {
            val fragment = CartFragment()
            this.supportFragmentManager.beginTransaction().replace(
                android.R.id.content,
                fragment
            ).addToBackStack(null).commit()
        }

        // Call the fetchRestaurants function
        fetchRestaurants()
    }

    private fun fetchRestaurants() {
        val retrofitInstance = RetrofitInstance()
        val apiService = retrofitInstance.restaurantApiService
        val call = apiService.fetchRestaurants()
        call.enqueue(object : Callback<List<Restaurant>> {
            override fun onResponse(
                call: Call<List<Restaurant>>,
                response: Response<List<Restaurant>>
            ) {
                if (response.isSuccessful) {
                    var restaurants = response.body()
                    Log.d("MainActivity", "Fetched restaurants: $restaurants")
                    // Pass the fetched restaurants to the FragmentRestos fragment
                    val fragmentRestos = supportFragmentManager.findFragmentById(R.id.fragment_restos) as? FragmentRestos
                    fragmentRestos?.updateRestaurantList(restaurants)
                } else {
                    val error = response.errorBody()?.string() ?: "Unknown error"
                    Log.e("MainActivity", "API Error: $error")
                    // Handle the error
                }
            }

            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                Log.e("MainActivity", "API Call Failed", t)
                // Handle the failure
            }
        })
    }


}

private fun <T> Call<T>.enqueue(callback: Callback<List<Restaurant>>) {

}
