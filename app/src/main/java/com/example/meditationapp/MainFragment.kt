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
import com.example.meditationapp.repository.RetrofitClient.service
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
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
        val feelings = mutableListOf<Feelings>()

        service.getFeelings().enqueue(object : retrofit2.Callback<List<Feelings>> {
            override fun onResponse(
                call: Call<List<Feelings>>,
                response: Response<List<Feelings>>
            ) {
                if (response.isSuccessful) {
                    val feelingsList = response.body()
                    if (!feelingsList.isNullOrEmpty()) {
                        val imageIrl = feelingsList[0].image

                        Picasso.get().load(imageIrl).into(binding.feeling1) // Загрузка и отображение изображения в ImageView
                    }
                    else {
                        Log.e("API Error", "Failed to get feelings: ${response.code()}")

                    }                            }
            }

            override fun onFailure(call: Call<List<Feelings>>, t: Throwable) {

            }
        })
        binding.btnMenu.setOnClickListener {
        }
        binding.btnListen.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_listenFragment)
        }

    }

}
