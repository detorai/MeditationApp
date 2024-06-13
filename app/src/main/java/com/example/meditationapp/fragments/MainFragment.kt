package com.example.meditationapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meditationapp.R
import com.example.meditationapp.data.FeelingsAdapter
import com.example.meditationapp.data.QuotesAdapter
import com.example.meditationapp.databinding.MainBinding
import com.example.meditationapp.network.RetrofitClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    lateinit var binding: MainBinding
    private lateinit var adapterF: FeelingsAdapter
    private lateinit var adapterQ: QuotesAdapter
    lateinit var recyclerViewF: RecyclerView
    lateinit var recyclerViewQ: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        view.visibility = View.VISIBLE


        binding.sendProfile.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_profileFragment2)
        }
        binding.btnMenu.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_menuFragment)
        }
        recyclerViewF = binding.recyclerForFeelings
        recyclerViewF.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        recyclerViewQ = binding.recyclerForQuotes
        recyclerViewQ.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        fetchDataAndUpdateUI()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun fetchDataAndUpdateUI() {
        lifecycleScope.launch {
            val response = RetrofitClient.service.getFeelings()
            if (response.success) {
                val feelings = response.data
                adapterF = FeelingsAdapter(feelings)
                adapterF.notifyDataSetChanged()
                recyclerViewF.adapter = adapterF
            } else {
                Log.d("My Error", "Ошибка при получении данных Feelings")
            }
            val response1 = RetrofitClient.service.getQuotes()
            if (response1.success) {
                val quotes = response1.data
                adapterQ = QuotesAdapter(quotes)
                adapterQ.notifyDataSetChanged()
                recyclerViewQ.adapter = adapterQ
            } else {
                Log.d("My Error", "Ошибка при получении данных")
            }
        }
    }
}



