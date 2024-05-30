package com.example.meditationapp.fragments

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.meditationapp.data.PhotoAdapter
import com.example.meditationapp.databinding.ProfileBinding

class ProfileFragment: Fragment() {
    lateinit var binding: ProfileBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoAdapter
    private val selectedImageUris = mutableListOf<Uri>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerForPhoto
        photoAdapter = PhotoAdapter(requireContext(),selectedImageUris)
        recyclerView.adapter=photoAdapter

        recyclerView.setOnClickListener {
            val start = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                if (uri != null) {
                    selectedImageUris.add(uri)
                    photoAdapter.notifyItemInserted(selectedImageUris.size - 1)
                    Log.d("PhotoPicker", "Selected URI: $uri")
            } else {
                Log.d("PhotoPicker", "No media selected")
                }
            }
        }

    }
}