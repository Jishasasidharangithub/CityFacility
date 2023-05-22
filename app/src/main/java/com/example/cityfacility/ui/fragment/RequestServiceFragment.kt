package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentHomeBinding
import com.example.cityfacility.databinding.FragmentRequestServiceBinding
import com.example.cityfacility.ui.adapter.OurServiceAdapter
import com.example.cityfacility.ui.adapter.SelectedServiceAdapter
import com.example.cityfacility.ui.modelclass.OurServiceItem
import com.example.cityfacility.ui.modelclass.SelectedServicesItem

class RequestServiceFragment : Fragment() {

    private var binding: FragmentRequestServiceBinding? = null

    private val selectedServiceAdapter: SelectedServiceAdapter by lazy { SelectedServiceAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRequestServiceBinding.inflate(
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

    fun initView() {
        binding?.rvSelectedService?.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 2, LinearLayoutManager.HORIZONTAL, false)
            adapter = selectedServiceAdapter
                serviceData()
        }
    }

    fun serviceData() {

        val subList = listOf(
            SelectedServicesItem(
                "A/C Service"
            ),
            SelectedServicesItem(
                "A/C Repair"
            ),
            SelectedServicesItem(
                "A/C Coil Cleaning"
            ),
            SelectedServicesItem(
                "A/C Duct Cleaning"
            )
        )
        selectedServiceAdapter.updateList(subList)


    }

}