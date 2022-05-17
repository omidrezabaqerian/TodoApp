package com.omidrezabagherian.todoapplication.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.omidrezabagherian.todoapplication.R
import com.omidrezabagherian.todoapplication.databinding.FragmentHostBinding
import com.omidrezabagherian.todoapplication.ui.util.ViewPagerAdapter

class HostFragment : Fragment(R.layout.fragment_host) {
    private lateinit var hostBinding: FragmentHostBinding
    private val navController by lazy {
        findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hostBinding = FragmentHostBinding.bind(view)

        navController.enableOnBackPressed(false)

        hostBinding.viewPagerHost.adapter = ViewPagerAdapter(childFragmentManager, lifecycle)

        TabLayoutMediator(hostBinding.tabLayoutHost, hostBinding.viewPagerHost) { tab, pos ->
            when (pos) {
                0 -> tab.text = "کار های من"
                1 -> tab.text = "در حال انجام"
                2 -> tab.text = "کار های تکمیل شده"
            }
        }.attach()

        hostBinding.floatingActionButtonHost.setOnClickListener {
            navController.navigate(R.id.insertFragment)
        }

    }
}