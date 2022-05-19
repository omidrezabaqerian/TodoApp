package com.omidrezabagherian.todoapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.omidrezabagherian.todoapplication.R
import com.omidrezabagherian.todoapplication.databinding.FragmentHostBinding
import com.omidrezabagherian.todoapplication.ui.util.VariableConst
import com.omidrezabagherian.todoapplication.ui.util.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostFragment : Fragment(R.layout.fragment_host) {

    private lateinit var hostBinding: FragmentHostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hostBinding = FragmentHostBinding.inflate(layoutInflater)

        val adapter = ViewPagerAdapter(
            childFragmentManager, lifecycle
        )
        hostBinding.viewPagerTodo.adapter = adapter

        TabLayoutMediator(hostBinding.tabLayoutTodo, hostBinding.viewPagerTodo) { tab, position ->
            tab.text = VariableConst.TABS[position]
        }.attach()

    }
}