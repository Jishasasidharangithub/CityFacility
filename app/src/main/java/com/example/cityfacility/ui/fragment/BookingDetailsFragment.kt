package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentBookingDetailsBinding
import com.example.cityfacility.databinding.FragmentCheckOutBinding
import com.example.cityfacility.ui.adapter.BookingDetailItemAdapter
import com.example.cityfacility.ui.adapter.CheckOutItemAdapter
import com.example.cityfacility.ui.modelclass.BookingDetailItem
import com.example.cityfacility.ui.modelclass.CheckOutItem

class BookingDetailsFragment : Fragment() {

    private val bookingDetailItemAdapter: BookingDetailItemAdapter by lazy { BookingDetailItemAdapter() }
    private var binding: FragmentBookingDetailsBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookingDetailsBinding.inflate(
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
        binding?.rvMybookingDetails?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = bookingDetailItemAdapter
            bookingDetailData()
        }
    }
    fun bookingDetailData() {
        val subList = listOf(
            BookingDetailItem(
                "A/C Service",
                "1 A/C Unit",
                "AED 250"
            ), BookingDetailItem(
                "A/C Repair",
                "1 A/C Unit",
                "AED 175"
            )
        )
        bookingDetailItemAdapter.updateList(subList)}

}