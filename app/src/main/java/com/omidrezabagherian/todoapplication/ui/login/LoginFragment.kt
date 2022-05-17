package com.omidrezabagherian.todoapplication.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.omidrezabagherian.todoapplication.R
import com.omidrezabagherian.todoapplication.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var loginBinding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()
    private val navController by lazy {
        findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBinding = FragmentLoginBinding.bind(view)

        loginBinding.buttonLogin.setOnClickListener {
            checkLogin(
                loginBinding.textInputEditTextLoginUsername.text.toString(),
                loginBinding.textInputEditTextLoginPassword.text.toString(),
                view
            )
        }

        loginBinding.textViewRegister.setOnClickListener {
            val dir = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            navController.navigate(dir)
        }

        loginBinding.textViewForget.setOnClickListener {
            val dir = LoginFragmentDirections.actionLoginFragmentToForgetFragment()
            navController.navigate(dir)
        }

    }

    private fun checkLogin(username: String, password: String, view: View) {
        loginViewModel.checkLogin(username, password)

        lifecycleScope.launch {
            loginViewModel.checkUsernameLogin.collect {
                if (it != null) {
                    Snackbar.make(
                        requireContext(),
                        view,
                        "حساب کاربری ساخته شد",
                        Snackbar.LENGTH_SHORT
                    ).show()

                    val todoActivity = Intent(requireActivity(), TodoActivity::class.java)
                    startActivity(todoActivity)
                    requireActivity().finish()

                } else {
                    Snackbar.make(
                        requireContext(),
                        view,
                        "نام کاربری وجود ندارد",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
}