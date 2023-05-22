package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentMaintenancePackageBinding
import com.example.cityfacility.databinding.FragmentMySubscriptionBinding
import com.example.cityfacility.ui.adapter.MaintenanceItemAdapter
import com.example.cityfacility.ui.adapter.SubscriptionItemAdapter
import com.example.cityfacility.ui.modelclass.MaintenanceItem
import com.example.cityfacility.ui.modelclass.SubscribedItem

class MySubscriptionFragment : Fragment() {

    private val subscriptionItemAdapter: SubscriptionItemAdapter by lazy { SubscriptionItemAdapter() }
    private var binding: FragmentMySubscriptionBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMySubscriptionBinding.inflate(
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
    fun initView(){
        binding?.rvMySubscription?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = subscriptionItemAdapter
            subscriptionData()
        }
    }

    fun subscriptionData() {
        val subList = listOf(
            SubscribedItem(
                "BASIC",
                "AED 250"
            ), SubscribedItem(
                "STANDARD",
                "AED 250"
            )
        )
        subscriptionItemAdapter.updateList(subList)}


}