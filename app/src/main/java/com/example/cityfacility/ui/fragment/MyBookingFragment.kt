package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentMyBookingBinding
import com.example.cityfacility.databinding.FragmentMyPaymentBinding
import com.example.cityfacility.ui.adapter.BookingItemAdapter
import com.example.cityfacility.ui.adapter.PaymentItemAdapter
import com.example.cityfacility.ui.modelclass.BookingItem
import com.example.cityfacility.ui.modelclass.PaymentItem

class MyBookingFragment : Fragment() {

    private val bookingItemAdapter: BookingItemAdapter by lazy { BookingItemAdapter() }
    private var binding: FragmentMyBookingBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyBookingBinding.inflate(
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
        binding?.rvMybooking?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = bookingItemAdapter
            bookingData()
        }
    }
    fun bookingData() {
        val subList = listOf(
            BookingItem(
                "0587",
                "Completed",
                "14-07-2023",
                "09.00 am - 11.00 am"
            ), BookingItem(
                "0587",
                "Completed",
                "14-07-2023",
                "09.00 am - 11.00 am"
            ), BookingItem(
                "0587",
                "Completed",
                "14-07-2023",
                "09.00 am - 11.00 am"
            ), BookingItem(
                "0587",
                "Completed",
                "14-07-2023",
                "09.00 am - 11.00 am"
            )
        )
        bookingItemAdapter.updateList(subList)}

}