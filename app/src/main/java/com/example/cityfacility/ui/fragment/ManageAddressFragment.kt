package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentManageAddressBinding
import com.example.cityfacility.databinding.FragmentMyPaymentBinding
import com.example.cityfacility.ui.adapter.ManageItemAdapter
import com.example.cityfacility.ui.adapter.PaymentItemAdapter
import com.example.cityfacility.ui.modelclass.ManageItem
import com.example.cityfacility.ui.modelclass.PaymentItem

class ManageAddressFragment : Fragment() {

    private val manageItemAdapter: ManageItemAdapter by lazy { ManageItemAdapter() }
    private var binding: FragmentManageAddressBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentManageAddressBinding.inflate(
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
        binding?.rvManageAddress?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = manageItemAdapter
            manageAddresstData()
        }
    }
    fun manageAddresstData() {
        val subList = listOf(
            ManageItem(
                "Address1",
                "UserName",
                "Plot 85 Trade Center Trade Center District,Dudhai-United Arab Emirates +917 894346653"
            ), ManageItem(
                "Address1",
                "UserName",
                "Plot 85 Trade Center Trade Center District,Dudhai-United Arab Emirates +917 894346653"
            )
        )
        manageItemAdapter.updateList(subList)}
}