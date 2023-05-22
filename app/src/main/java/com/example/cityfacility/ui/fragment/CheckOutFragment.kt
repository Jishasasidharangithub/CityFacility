package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentCheckOutBinding
import com.example.cityfacility.databinding.FragmentMaintenancePackageBinding
import com.example.cityfacility.ui.adapter.CheckOutItemAdapter
import com.example.cityfacility.ui.adapter.MaintenanceItemAdapter
import com.example.cityfacility.ui.modelclass.CheckOutItem
import com.example.cityfacility.ui.modelclass.MaintenanceItem

class CheckOutFragment : Fragment() {
    private val checkOutItemAdapter: CheckOutItemAdapter by lazy { CheckOutItemAdapter() }
    private var binding: FragmentCheckOutBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCheckOutBinding.inflate(
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
        binding?.rvCheckOut?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
            adapter = checkOutItemAdapter
            checkoutData()
        }
    }
    fun checkoutData() {
        val subList = listOf(
            CheckOutItem(
                "A/C Service",
                "1 A/C Unit",
                "AED 250"
            ), CheckOutItem(
                "A/C Repair",
                "1 A/C Unit",
                "AED 175"
            )
        )
        checkOutItemAdapter.updateList(subList)}

}