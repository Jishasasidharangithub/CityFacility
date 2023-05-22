package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentOffersBinding
import com.example.cityfacility.databinding.FragmentOurServicesBinding
import com.example.cityfacility.ui.adapter.OfferItemAdapter
import com.example.cityfacility.ui.adapter.OurServiceAdapter
import com.example.cityfacility.ui.modelclass.OfferItem
import com.example.cityfacility.ui.modelclass.OurServiceItem

class OffersFragment : Fragment() {

    private val offerItemAdapter: OfferItemAdapter by lazy { OfferItemAdapter() }
    private var binding: FragmentOffersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOffersBinding.inflate(
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
        binding?.rvOffers?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = offerItemAdapter
            offerData()
        }
    }

    fun offerData() {
        val subList = listOf(
            OfferItem(
                R.drawable.image1,
            ), OfferItem(
                R.drawable.image2,
            )
        )
        offerItemAdapter.updateList(subList)
    }
}