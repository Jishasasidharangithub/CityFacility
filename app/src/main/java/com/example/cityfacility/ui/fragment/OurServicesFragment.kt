package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentHomeBinding
import com.example.cityfacility.databinding.FragmentOurServicesBinding
import com.example.cityfacility.ui.adapter.OurServiceAdapter
import com.example.cityfacility.ui.adapter.SubServiceAdapter
import com.example.cityfacility.ui.modelclass.OurServiceItem
import com.example.cityfacility.ui.modelclass.SubServiceItem

class OurServicesFragment : Fragment() {

    private val ourServiceAdapter: OurServiceAdapter by lazy { OurServiceAdapter() }
    private var binding: FragmentOurServicesBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOurServicesBinding.inflate(
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
        binding?.rvServices?.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 3)
            adapter = ourServiceAdapter
            serviceData()
        }
    }

    fun serviceData() {
        val subList = listOf(
            OurServiceItem(
                R.drawable.ic_sanitizer,
                "Disinfection",
            ), OurServiceItem(
                R.drawable.ic_sanitizer,
                "Air Conditioning",
            ), OurServiceItem(
                R.drawable.ic_sanitizer,
                "Cleaning Service",
            ), OurServiceItem(
                R.drawable.ic_sanitizer,
                "Electrical",
            ), OurServiceItem(
                R.drawable.ic_sanitizer,
                "Handyman",
            ), OurServiceItem(
                R.drawable.ic_sanitizer,
                "Home Improvement",
            ) ,OurServiceItem(
                    R.drawable.ic_sanitizer,
            "Plumbing Service"
            ),OurServiceItem(
                R.drawable.ic_sanitizer,
                "Smart Home Product"
            ), OurServiceItem(
                R.drawable.ic_sanitizer,
                "Swimming Pool Service"
            ), OurServiceItem(
                R.drawable.ic_sanitizer,
                "Water Tank Cleaning"
            ), OurServiceItem(
                R.drawable.ic_sanitizer,
                "Pest Control"
            ), OurServiceItem(
                R.drawable.ic_sanitizer,
                "Move In / Mone Out"),
        )
        ourServiceAdapter.updateList(subList)
    }

}