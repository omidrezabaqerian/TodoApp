package com.omidrezabagherian.todoapplication.ui.register

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.omidrezabagherian.todoapplication.R
import com.omidrezabagherian.todoapplication.data.model.User
import com.omidrezabagherian.todoapplication.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var registerBinding: FragmentRegisterBinding
    private val navController by lazy { findNavController() }
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerBinding = FragmentRegisterBinding.bind(view)
        registerBinding.buttonRegister.setOnClickListener {

            if (registerBinding.textInputEditTextRegisterPassword.text.toString() == registerBinding.textInputEditTextRegisterRetypePassword.text.toString()) {
                val user = User(
                    registerBinding.textInputEditTextRegisterUsername.text.toString(),
                    registerBinding.textInputEditTextRegisterFirstname.text.toString(),
                    registerBinding.textInputEditTextRegisterLastname.text.toString(),
                    registerBinding.textInputEditTextRegisterPassword.text.toString(),
                    registerBinding.textInputEditTextRegisterWordSecurity.text.toString()
                )

                insertUser(user, view)
            } else {
                Snackbar.make(
                    requireContext(),
                    view,
                    "رمز عبور با تکرارش یکی نمیباشند",
                    Snackbar.LENGTH_SHORT
                )
                    .show()
            }

            /*val dir = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            navController.navigate(dir)*/
        }

    }

    private fun insertUser(user: User, view: View) {
        registerViewModel.checkUsername(user.username)

        lifecycleScope.launch {
            registerViewModel.checkUsername.collect {
                if (it == null) {
                    Snackbar.make(
                        requireContext(),
                        view,
                        "حساب کاربری ساخته شد",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()

                    registerViewModel.insertRegister(user)

                    Log.i("user", it.toString())

                } else {
                    Snackbar.make(
                        requireContext(),
                        view,
                        "نام کاربری موجود هست",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()

                    Log.i("user", it.toString())
                }
            }
        }
    }

}