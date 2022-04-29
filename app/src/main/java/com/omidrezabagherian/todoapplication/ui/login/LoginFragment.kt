package com.omidrezabagherian.todoapplication.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.omidrezabagherian.todoapplication.R
import com.omidrezabagherian.todoapplication.databinding.FragmentLoginBinding
import com.omidrezabagherian.todoapplication.databinding.FragmentRegisterBinding
import com.omidrezabagherian.todoapplication.ui.TodoActivity
import com.omidrezabagherian.todoapplication.ui.register.RegisterFragmentDirections

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var loginBinding: FragmentLoginBinding
    private val navController by lazy {
        findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBinding = FragmentLoginBinding.bind(view)

        loginBinding.buttonLogin.setOnClickListener {
            val goToApp = Intent(requireActivity(), TodoActivity::class.java)
            startActivity(goToApp)
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
}