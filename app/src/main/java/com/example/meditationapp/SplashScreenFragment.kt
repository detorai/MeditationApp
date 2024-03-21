package com.example.meditationapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.meditationapp.databinding.SplashScreenBinding

class SplashScreenFragment : Fragment() {

    lateinit var binding: SplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = SplashScreenBinding.inflate(layoutInflater, container, false)
        Handler(Looper.myLooper()!!).postDelayed({
            findNavController().navigate(R.id.action_splashScreenFragment_to_onBoardingFragment)
        }, 3000)
        return binding.root
    }
}