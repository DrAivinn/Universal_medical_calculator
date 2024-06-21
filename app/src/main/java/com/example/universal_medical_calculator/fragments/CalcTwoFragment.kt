package com.example.universal_medical_calculator.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.universal_medical_calculator.databinding.FragmentCalcTwoBinding

class CalcTwoFragment : BaseCalculatorFragment<FragmentCalcTwoBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCalcTwoBinding {
        return FragmentCalcTwoBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner(binding.spinner)
        binding.calculateBTN.setOnClickListener {
            val volumeOfSolution = binding.volumeOfSolutionTIL.editText?.text.toString()
            val time = binding.timeTIL.editText?.text.toString()
            if (volumeOfSolution.isBlank() || time.isBlank()) {
                Toast.makeText(
                    requireContext(),
                    "Заполните все данные!",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val result = volumeOfSolution.toDouble() / time.toDouble()
                saveResult(result, binding.drugInfusionRateTV, 2)
            }
        }
    }
}