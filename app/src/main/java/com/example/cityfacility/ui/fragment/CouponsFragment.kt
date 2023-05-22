package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentCouponsBinding
import com.example.cityfacility.databinding.FragmentLocationBinding
import com.example.cityfacility.ui.adapter.LocationAdapter
import com.example.cityfacility.ui.modelclass.CouponsItem
import com.example.cityfacility.ui.modelclass.OurServiceItem

class CouponsFragment : Fragment() {

    private var binding: FragmentCouponsBinding? = null

    private val couponsItemAdapter: CouponsItemAdapter by lazy { CouponsItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCouponsBinding.inflate(
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
        binding?.rvCoupons?.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 2)
            adapter = couponsItemAdapter
            couponsData()
        }
    }

    fun couponsData() {
        val subList = listOf(
            CouponsItem(
                "Flat 30% OFF",
                "G5674872632"
            ), CouponsItem(
                "Flat 30% OFF",
                "G5674872632"
            )
        )
        couponsItemAdapter.updateList(subList)
    }

}