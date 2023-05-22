package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleEvents()
    }
    fun handleEvents(){
        binding?.tvRegister?.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }

        binding?.btnLogin?.setOnClickListener {
            findNavController().navigate(R.id.locationFragment)
        }

    }


}