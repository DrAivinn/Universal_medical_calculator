package com.example.universal_medical_calculator.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.universal_medical_calculator.R
import com.example.universal_medical_calculator.databinding.FragmentCalculatorsBinding

class CalculatorsFragment : FragmentBase<FragmentCalculatorsBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentCalculatorsBinding {
        return FragmentCalculatorsBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            calcOneBTN.setOnClickListener {
                findNavController().navigate(R.id.action_calculatorsFragment_to_calcOneFragment)
            }
            calcTwoBTN.setOnClickListener {
                findNavController().navigate(R.id.action_calculatorsFragment_to_calcTwoFragment)
            }
            calcThreeBTN.setOnClickListener {
                findNavController().navigate(R.id.action_calculatorsFragment_to_calcThreeFragment)
            }
            calcFourBTN.setOnClickListener {
                findNavController().navigate(R.id.action_calculatorsFragment_to_calcFourFragment)
            }
        }
    }
}