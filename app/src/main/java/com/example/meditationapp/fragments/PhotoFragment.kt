package com.example.meditationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.meditationapp.R
import com.example.meditationapp.databinding.PhotoBinding
import com.example.meditationapp.databinding.ProfileBinding

class PhotoFragment : Fragment() {

    lateinit var binding: PhotoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PhotoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       binding.deleteButton.setOnClickListener{
           findNavController().navigate(R.id.action_profileFragment2_to_photoFragment)
       }
       binding.closeButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment2_to_photoFragment)
       }
    }

}