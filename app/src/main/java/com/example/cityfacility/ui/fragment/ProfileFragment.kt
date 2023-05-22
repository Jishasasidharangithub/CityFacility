package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleEvents()
    }

    fun handleEvents(){
        binding?.cvProfileCvItem?.setOnClickListener {
            findNavController().navigate(R.id.myBookingFragment)
        }

        binding?.cvMyPayment?.setOnClickListener {
            findNavController().navigate(R.id.myPaymentFragment)
        }

        binding?.cvMySubscription?.setOnClickListener {
            findNavController().navigate(R.id.mySubscriptionFragment)
        }

        binding?.cslWishList?.setOnClickListener {
            findNavController().navigate(R.id.wishListFragment)
        }

        binding?.cslChangePassword?.setOnClickListener {
            findNavController().navigate(R.id.changePasswordFragment)
        }

        binding?.cslManageAddress?.setOnClickListener {
            findNavController().navigate(R.id.manageAddressFragment)
        }

        binding?.tvEdit?.setOnClickListener {
            findNavController().navigate(R.id.editFragment)
        }


    }

}