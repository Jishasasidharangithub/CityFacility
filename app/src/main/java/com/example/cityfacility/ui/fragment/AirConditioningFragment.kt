package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentAirConditioningBinding
import com.example.cityfacility.databinding.FragmentMaintenancePackageBinding
import com.example.cityfacility.ui.adapter.AirConditionItemAdapter
import com.example.cityfacility.ui.adapter.MaintenanceItemAdapter
import com.example.cityfacility.ui.modelclass.AirConditioningItem
import com.example.cityfacility.ui.modelclass.MaintenanceItem

class AirConditioningFragment : Fragment() {

    private val airConditionItemAdapter: AirConditionItemAdapter by lazy { AirConditionItemAdapter() }
    private var binding: FragmentAirConditioningBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAirConditioningBinding.inflate(
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
        binding?.rvAirConditioning?.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
            adapter = airConditionItemAdapter
            airConditionData()
        }
    }

    fun airConditionData() {
        val subList = listOf(
            AirConditioningItem(
                "A/C Service",
                "AED 250"
            ), AirConditioningItem(
                "A/C Repair",
                "AED 250"
            ), AirConditioningItem(
                "A/C Coil Cleaning",
                "AED 250"
            ), AirConditioningItem(
                "A/C Duct Cleaning",
                "AED 250"
            )
        )
        airConditionItemAdapter.updateList(subList)}

}