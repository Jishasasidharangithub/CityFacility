package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentFaqBinding
import com.example.cityfacility.databinding.FragmentNotificationBinding
import com.example.cityfacility.ui.adapter.FAQItemAdapter
import com.example.cityfacility.ui.adapter.NotificationItemAdapter
import com.example.cityfacility.ui.modelclass.FAQItem
import com.example.cityfacility.ui.modelclass.NotificationItem

class NotificationFragment : Fragment() {

    private var binding: FragmentNotificationBinding?= null
    private val notificationItemAdapter: NotificationItemAdapter by lazy { NotificationItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){

        binding?.rvNotification?.apply {
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = notificationItemAdapter
            notificationData()
        }
    }

    fun notificationData() {
        val subList = listOf(
            NotificationItem(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras varius posuere aliquam. Curabitur urna mauris, tempor fringilla luctus eu, eleifend sit amet elit.",
                "04-09-2023",
            ), NotificationItem(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras varius posuere aliquam. Curabitur urna mauris, tempor fringilla luctus eu, eleifend sit amet elit.",
                "04-09-2023",
            ))


        notificationItemAdapter.updateList(subList)
    }

}