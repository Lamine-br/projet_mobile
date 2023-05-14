package com.example.movieexample

import MyAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieexample.databinding.FragmentRestosBinding

class FragmentRestos : Fragment() {

    lateinit var binding: FragmentRestosBinding
    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRestosBinding.inflate(layoutInflater)
        val view = binding.root

        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        // Initialize the adapter with an empty list
        adapter = MyAdapter(emptyList())
        binding.recyclerView.adapter = adapter

        return view
    }

    fun updateRestaurantList(restaurants: List<com.example.movieexample.models.Restaurant>?) {
        if (restaurants != null) {
            adapter.updateData(restaurants)
        }
    }
    private fun loadData(restaurants: List<Restaurant>): List<Restaurant> {
        // Return the list of restaurants received as a parameter
        return restaurants
    }
}