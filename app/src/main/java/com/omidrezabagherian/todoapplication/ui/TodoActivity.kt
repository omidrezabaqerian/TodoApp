package com.omidrezabagherian.todoapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.omidrezabagherian.todoapplication.databinding.ActivityTodoBinding
import com.omidrezabagherian.todoapplication.ui.util.VariableConst
import com.omidrezabagherian.todoapplication.ui.util.ViewPagerAdapter

class TodoActivity : AppCompatActivity() {

    private lateinit var todoBinding: ActivityTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        todoBinding = ActivityTodoBinding.inflate(layoutInflater)

        val adapter = ViewPagerAdapter(
            supportFragmentManager, lifecycle
        )
        todoBinding.viewPagerTodo.adapter = adapter

        TabLayoutMediator(todoBinding.tabLayoutTodo, todoBinding.viewPagerTodo) { tab, position ->
            tab.text = VariableConst.TABS[position]
        }.attach()

        setContentView(todoBinding.root)
    }
}