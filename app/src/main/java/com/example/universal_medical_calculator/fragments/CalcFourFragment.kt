package com.example.universal_medical_calculator.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.universal_medical_calculator.databinding.FragmentCalcFourBinding

class CalcFourFragment : BaseCalculatorFragment<FragmentCalcFourBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentCalcFourBinding {
        return FragmentCalcFourBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner(binding.spinner)
        binding.calculateBTN.setOnClickListener {
            val volumeOfSolution =
                binding.volumeOfSolutionTIL.editText?.text.toString()
            val numberOfDrops = binding.numberOfDropsTIL.editText?.text.toString()
            val time = binding.timeTIL.editText?.text.toString()
            if (volumeOfSolution.isBlank() || numberOfDrops.isBlank() || time.isBlank()) {
                Toast.makeText(
                    requireContext(),
                    "Заполните все данные!",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val result =
                    (volumeOfSolution.toDouble() * numberOfDrops.toDouble()) / time.toDouble()
                saveResult(result, binding.drugSpeedTV, 4)
            }
        }

    }
}