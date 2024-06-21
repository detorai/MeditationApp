package com.example.meditationapp.fragments


/*import com.example.meditationapp.ViewModel.LoginViewModel*/
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.meditationapp.R
import com.example.meditationapp.ViewModel.LoginViewModel
import com.example.meditationapp.databinding.LoginBinding


class LoginFragment : Fragment() {

    lateinit var binding: LoginBinding
    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.apply {
            textRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
            btnSignIn.setOnClickListener {
                val email = binding.email.text.toString()
                val password = binding.password.text.toString()
                if (email.isEmpty()) {

                    Toast.makeText(requireContext(), "Пожалуйста, введите Email", Toast.LENGTH_SHORT)
                    .show()

                } /*else if (!email.contains("@")) {

                Toast.makeText(requireContext(), "Email введен неправильно", Toast.LENGTH_SHORT)
                    .show()

                } */else if (password.isEmpty()) {

                Toast.makeText(requireContext(), "Пожалуйста, введите пароль", Toast.LENGTH_SHORT)
                    .show()

                } else {
                loginViewModel.authorize(email, password)
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                }
            }
        }
    }
}




