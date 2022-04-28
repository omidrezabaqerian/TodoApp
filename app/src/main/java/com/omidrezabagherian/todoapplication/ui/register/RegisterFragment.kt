package com.omidrezabagherian.todoapplication.ui.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.omidrezabagherian.todoapplication.R
import com.omidrezabagherian.todoapplication.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var registerBinding: FragmentRegisterBinding
    private val navController by lazy {
        findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerBinding = FragmentRegisterBinding.bind(view)

        registerBinding.buttonRegister.setOnClickListener {
            val dir = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            navController.navigate(dir)
        }

    }
}