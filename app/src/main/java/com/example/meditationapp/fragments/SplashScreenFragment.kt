package com.example.meditationapp.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.meditationapp.R
import com.example.meditationapp.ViewModel.LoginViewModel
import com.example.meditationapp.databinding.SplashScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

class SplashScreenFragment : Fragment() {

    lateinit var binding: SplashScreenBinding
    private val loginViewModel: LoginViewModel by activityViewModels()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        view.visibility = View.GONE

        lifecycleScope.launch {
            loginViewModel.userData.collect{ user ->
                if (user != null ){
                    findNavController().navigate(R.id.mainFragment)
                }
            }
        }
    }
}