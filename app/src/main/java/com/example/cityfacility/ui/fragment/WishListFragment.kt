package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentOurServicesBinding
import com.example.cityfacility.databinding.FragmentWishListBinding
import com.example.cityfacility.ui.adapter.OurServiceAdapter
import com.example.cityfacility.ui.adapter.WishListItemAdapter
import com.example.cityfacility.ui.modelclass.OurServiceItem
import com.example.cityfacility.ui.modelclass.WishListItem

class WishListFragment : Fragment() {

    private val wishListItemAdapter: WishListItemAdapter by lazy { WishListItemAdapter() }
    private var binding: FragmentWishListBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWishListBinding.inflate(
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
        binding?.rvWishList?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = wishListItemAdapter
            wishListData()
        }
    }

    fun wishListData() {
        val subList = listOf(
            WishListItem(
                "A/C Service",
                "AED 200"
            ), WishListItem(
                "Disinfection",
                "AED 200"
            )
        )
        wishListItemAdapter.updateList(subList)
    }
}