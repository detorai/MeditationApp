package com.example.meditationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
/*import com.example.meditationapp.data.Product*/
import com.example.meditationapp.databinding.LoginBinding
import com.example.meditationapp.databinding.OnboardingBinding
/*import com.example.meditationapp.repository.RetrofitRepository*/
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {

    lateinit var binding: LoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnSignIn.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            if (email.isEmpty()) {

                Toast.makeText(requireContext(), "Пожалуйста, введите Email", Toast.LENGTH_SHORT)
                    .show()

            } else if (!email.contains("@")) {

                Toast.makeText(requireContext(), "Email введен неправильно", Toast.LENGTH_SHORT)
                    .show()

            } else if (password.isEmpty()) {

                Toast.makeText(requireContext(), "Пожалуйста, введите пароль", Toast.LENGTH_SHORT)
                    .show()

            }
            else {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
        }
    }
}
    /*    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = RetrofitRepository.create()
        val productAnswer = flow<List<Product>> {
            emit(product.getProduct())
        }
        lifecycleScope.launch {
            productAnswer.flowOn(Dispatchers.IO)
                .collect{
                    Toast.makeText(requireContext(), it.last().id, Toast.LENGTH_SHORT).show()
                }
        }
    }*/

