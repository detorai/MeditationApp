package com.example.meditationapp.fragments

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meditationapp.R
import com.example.meditationapp.ViewModel.LoginViewModel
import com.example.meditationapp.ViewModel.PhotoViewModel
import com.example.meditationapp.data.PhotoAdapter
import com.example.meditationapp.databinding.ProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class ProfileFragment: Fragment() {
    lateinit var binding: ProfileBinding
    private lateinit var recyclerView: RecyclerView
    lateinit var photoAdapter: PhotoAdapter
    private val photoViewModel: PhotoViewModel by viewModels()
    val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val view1 = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        view1.visibility = View.VISIBLE

        lifecycleScope.launch {
            loginViewModel.userData.collect{ user ->
                if (user != null ){
                    binding.ProfileNickname.text = user.nickName
                    Picasso.get().load(user.avatar).into(binding.ProfilePhoto)
                }
            }
        }

        recyclerView = binding.recyclerForPhoto
        recyclerView.layoutManager = GridLayoutManager (requireContext(), 2)

        val imageList: MutableList<Uri> = mutableListOf()
        imageList.add(Uri.parse("android.resource://"+ requireContext().packageName + "/" + R.drawable.rectangle))
        photoAdapter = PhotoAdapter(requireContext(), imageList)
        recyclerView.adapter = photoAdapter

        val pickMultipleMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uris ->
            uris?.let { photoAdapter.addItem(it) }
        }
        photoAdapter.onClickButton  = {
            pickMultipleMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
        photoAdapter.onClickImage = {
            findNavController().navigate(R.id.action_profileFragment2_to_photoFragment)
            photoViewModel.uri.value = it
        }
    }
}