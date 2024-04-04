package com.example.meditationapp

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
import com.example.meditationapp.data.FeelingsAdapter
import com.example.meditationapp.databinding.MainBinding
import com.example.meditationapp.repository.RetrofitClient
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    lateinit var binding: MainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FeelingsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainBinding.inflate(layoutInflater, container, false)
        return binding.root


    }
    companion object {
        fun newInstance() = MainFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener{
            Toast.makeText( requireContext(),"Переход по ссылке", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            Toast.makeText(requireContext(), "Переход по ссылке", Toast.LENGTH_SHORT).show()
        }

        binding.btnMenu.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_menuFragment)
        }
       /* binding.sendProfile.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_ProfileFragment)
        }*/
        recyclerView = binding.recyclerForFeelings
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        fetchDataAndUpdateUI()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun fetchDataAndUpdateUI() {
        lifecycleScope.launch {
            val response = RetrofitClient.service.getFeelings()
            if (response.success) {
                val feelings = response.data
                adapter = FeelingsAdapter(feelings)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
            }
            else {
                Log.d("My Error","Ошибка при получении данных Feeling.")
            }
        }
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response1 = RetrofitClient.service.getQuotes()
                if (response1.success) {
                    for (quote in response1.data) {
                        when (quote.id) {
                            1 -> {
                                binding.HB1.text = quote.title
                                binding.ST1.text = quote.description
                                Picasso.get().load(quote.image).into(binding.IFB1)
                            }

                            2 -> {
                                binding.HB2.text = quote.title
                                binding.ST2.text = quote.description
                                Picasso.get().load(quote.image).into(binding.IFB2)
                            }
                        }
                    }
                } else {
                    Log.d("My Error","Ошибка при получении данных Quotes.")
                }
            } catch (e: Exception) {
                Log.d("My Error","Произошла ошибка: ${e.message}")
            }
        }
    }
}
/*    private fun fetchDataAndUpdateUI() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response = RetrofitClient.service.getFeelings()
                if (response.success) {

                    val sortedData = response.data.sortedBy { it.position }

                    sortedData.forEach { feeling ->
                        when (feeling.position) {
                            1 -> {
                                binding.textForFeeling1.text = feeling.title
                                Picasso.get().load(feeling.image).into(binding.imageForFeeling1)
                            }

                            2 -> {
                                binding.textForFeeling2.text = feeling.title
                                Picasso.get().load(feeling.image).into(binding.imageForFeeling2)
                            }

                            3 -> {
                                binding.textForFeeling3.text = feeling.title
                                Picasso.get().load(feeling.image).into(binding.imageForFeeling3)
                            }

                            4 -> {
                                binding.textForFeeling4.text = feeling.title
                                Picasso.get().load(feeling.image).into(binding.imageForFeeling4)
                            }

                            5 -> {
                                binding.textForFeeling5.text = feeling.title
                                Picasso.get().load(feeling.image).into(binding.imageForFeeling5)
                            }
                        }
                    }
                } else {
                    Log.d("My Error","Ошибка при получении данных Feeling.")
                }

                val response1 = RetrofitClient.service.getQuotes()
                if (response1.success) {
                    for (quote in response1.data) {
                        when (quote.id) {
                            1 -> {
                                binding.HB1.text = quote.title
                                binding.ST1.text = quote.description
                                Picasso.get().load(quote.image).into(binding.IFB1)
                            }

                            2 -> {
                                binding.HB2.text = quote.title
                                binding.ST2.text = quote.description
                                Picasso.get().load(quote.image).into(binding.IFB2)
                            }
                        }
                    }
                } else {
                    Log.d("My Error","Ошибка при получении данных Quotes.")
                }
            } catch (e: Exception) {
                Log.d("My Error","Произошла ошибка: ${e.message}")
            }
        }
 }*/

