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
import com.example.cityfacility.databinding.FragmentMyPaymentBinding
import com.example.cityfacility.ui.adapter.MaintenanceItemAdapter
import com.example.cityfacility.ui.adapter.PaymentItemAdapter
import com.example.cityfacility.ui.modelclass.MaintenanceItem
import com.example.cityfacility.ui.modelclass.PaymentItem

class MyPaymentFragment : Fragment() {

    private val paymentItemAdapter: PaymentItemAdapter by lazy { PaymentItemAdapter() }
    private var binding: FragmentMyPaymentBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyPaymentBinding.inflate(
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
        binding?.rvMyPayment?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = paymentItemAdapter
            paymentData()
        }
    }
    fun paymentData() {
        val subList = listOf(
            PaymentItem(
                "A/C Service",
                "14-05-2023",
                "Cash on Arival",
                "AED 250"
            ), PaymentItem(
                "A/C Repair",
                "14-05-2023",
                "Cash on Arival",
                "AED 250"
            )
        )
        paymentItemAdapter.updateList(subList)}
}