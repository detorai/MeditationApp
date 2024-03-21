package com.example.meditationapp

import android.os.Bundle
import android.support.annotation.UiThread
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.currentRecomposeScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.meditationapp.data.Feelings
import com.example.meditationapp.databinding.MainBinding
import com.example.meditationapp.repository.RetrofitClient
import com.example.meditationapp.repository.RetrofitClient.service
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception
import javax.security.auth.callback.Callback


class MainFragment : Fragment() {

    lateinit var binding: MainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainBinding.inflate(layoutInflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMenu.setOnClickListener {
        }
        binding.btnListen.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_listenFragment)


        }
        fetchDataAndUpdateUI()
    }
    private fun fetchDataAndUpdateUI() {
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
                    println("Ошибка при получении данных.")
                }
            } catch (e: Exception) {
                println("Произошла ошибка: ${e.message}")
            }
        }
 }
}
