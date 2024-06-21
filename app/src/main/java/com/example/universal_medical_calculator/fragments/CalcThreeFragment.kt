package com.example.universal_medical_calculator.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.universal_medical_calculator.databinding.FragmentCalcThreeBinding

class CalcThreeFragment : BaseCalculatorFragment<FragmentCalcThreeBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentCalcThreeBinding {
        return FragmentCalcThreeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner(binding.spinner)
        binding.calculateBTN.setOnClickListener {
            val serumPotassium = binding.serumPotassiumTIL.editText?.text.toString()
            val weight = binding.weightTIL.editText?.text.toString()
            if (serumPotassium.isBlank() || weight.isBlank()) {
                Toast.makeText(
                    requireContext(),
                    "Заполните все данные!",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val result = (5.0 - serumPotassium.toDouble()) * 0.2 * weight.toDouble()
                saveResult(result, binding.potassiumDeficiencyTV,3)
            }
        }

    }
}