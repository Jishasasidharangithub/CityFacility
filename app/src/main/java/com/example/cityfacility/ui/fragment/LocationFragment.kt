package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentHomeBinding
import com.example.cityfacility.databinding.FragmentLocationBinding
import com.example.cityfacility.ui.adapter.LocationAdapter
import com.example.cityfacility.ui.adapter.PackageAdapter
import com.example.cityfacility.ui.modelclass.LocationItem
import com.example.cityfacility.ui.modelclass.SubServiceItem

class LocationFragment : Fragment() {

    private var binding: FragmentLocationBinding? = null

    private val locationAdapter: LocationAdapter by lazy { LocationAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLocationBinding.inflate(
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
        binding?.rvLocation?.apply {
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = locationAdapter
            locationData()
        }
    }

    private fun locationData(){
        val locationList = listOf(
            LocationItem(
                "Abu Dhabi",
            ), LocationItem(
                "Dubai",
            ),LocationItem(
                "Sharjah",
            ), LocationItem(
                "Umm al-Qaiwain",
            ), LocationItem(
                "Fujairah",
            ), LocationItem(
                "Ajman",
            )
        )


        locationAdapter.updateList(locationList)
    }
}
