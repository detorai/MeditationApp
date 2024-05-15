package com.example.meditationapp.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.meditationapp.R
import com.example.meditationapp.ViewModel.LoginViewModel
import com.example.meditationapp.data.AuthUser
import com.example.meditationapp.data.User
import com.example.meditationapp.databinding.LoginBinding
import com.example.meditationapp.data.ResponseWrapper
import com.example.meditationapp.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {

    lateinit var binding: LoginBinding
    private var loginViewModel: LoginViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginViewModel: LoginViewModel by viewModels()

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

                loginViewModel.authorize()
                CoroutineScope(Dispatchers.IO).launch {
                    val user = RetrofitClient.service.auth(
                        AuthUser(
                            binding.email.text.toString(),
                            binding.password.text.toString()
                        )
                    )
                    val userRes = getUser(AuthUser("abc", "abc"))
                    when(userRes){
                        is ResponseWrapper.Error -> {

                        }
                        is ResponseWrapper.Success ->{
                            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)

                        }
                    }

                }
            }
        }
    }


    private suspend fun getUser(authUser:AuthUser): ResponseWrapper<User> {
        val result = RetrofitClient.service.auth(authUser)
        if (result.isSuccessful){
            return ResponseWrapper.Success(result.body())
        }
        return  ResponseWrapper.Error(Exception())
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

