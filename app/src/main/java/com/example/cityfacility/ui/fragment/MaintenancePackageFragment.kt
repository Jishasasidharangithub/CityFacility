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
import com.example.cityfacility.databinding.FragmentOurServicesBinding
import com.example.cityfacility.ui.adapter.MaintenanceItemAdapter
import com.example.cityfacility.ui.adapter.OurServiceAdapter
import com.example.cityfacility.ui.modelclass.MaintenanceItem
import com.example.cityfacility.ui.modelclass.OurServiceItem

class MaintenancePackageFragment : Fragment() {

    private val maintenanceItemAdapter: MaintenanceItemAdapter by lazy { MaintenanceItemAdapter() }
    private var binding: FragmentMaintenancePackageBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMaintenancePackageBinding.inflate(
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
        binding?.rvMaintenancePackages?.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
            adapter = maintenanceItemAdapter
            maintenanceData()
        }
    }

    fun maintenanceData() {
        val subList = listOf(
            MaintenanceItem(
                "BASIC",
                "AED 250"
            ), MaintenanceItem(
                "STANDARD",
                "AED 250"
            ), MaintenanceItem(
                "eXECUTIVE",
                "AED 250"
            )
        )
        maintenanceItemAdapter.updateList(subList)}

}