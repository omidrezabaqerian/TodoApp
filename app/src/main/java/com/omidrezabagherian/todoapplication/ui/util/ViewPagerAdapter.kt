package com.omidrezabagherian.todoapplication.ui.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.omidrezabagherian.todoapplication.ui.doing.DoingFragment
import com.omidrezabagherian.todoapplication.ui.done.DoneFragment
import com.omidrezabagherian.todoapplication.ui.todo.TodoFragment
import com.omidrezabagherian.todoapplication.ui.util.VariableConst


class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return VariableConst.NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return TodoFragment()
            1 -> return DoingFragment()
            2 -> return DoneFragment()
        }
        return TodoFragment()
    }

}