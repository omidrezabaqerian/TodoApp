package com.omidrezabagherian.todoapplication.ui.todo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.omidrezabagherian.todoapplication.R
import com.omidrezabagherian.todoapplication.databinding.FragmentTodoBinding

class TodoFragment : Fragment(R.layout.fragment_todo) {

    private lateinit var todoBinding: FragmentTodoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        todoBinding = FragmentTodoBinding.bind(view)

        todo

    }
}