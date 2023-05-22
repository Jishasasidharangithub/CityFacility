package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentBookingDetailsBinding
import com.example.cityfacility.databinding.FragmentCartBinding
import com.example.cityfacility.ui.adapter.BookingDetailItemAdapter
import com.example.cityfacility.ui.adapter.CartItemAdapter
import com.example.cityfacility.ui.modelclass.BookingDetailItem
import com.example.cityfacility.ui.modelclass.CartItem

class CartFragment : Fragment() {

    private val cartItemAdapter: CartItemAdapter by lazy { CartItemAdapter() }
    private var binding: FragmentCartBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(
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
        binding?.rvCart?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = cartItemAdapter
            cartData()
        }
    }

    fun cartData() {
        val subList = listOf(
            CartItem(
                "A/C Service",
                "1 A/C Unit",
                "AED 250"
            ), CartItem(
                "A/C Repair",
                "1 A/C Unit",
                "AED 175"
            )
        )
        cartItemAdapter.updateList(subList)}

}