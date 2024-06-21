package com.example.universal_medical_calculator.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.universal_medical_calculator.databinding.FragmentCalcOneBinding


class CalcOneFragment : BaseCalculatorFragment<FragmentCalcOneBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentCalcOneBinding {
        return FragmentCalcOneBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner(binding.spinner)
        binding.calculateBTN.setOnClickListener {
            val height = binding.heightTIL.editText?.text.toString()
            val weight = binding.weightTIL.editText?.text.toString()
            if (height.isBlank() || weight.isBlank()) {
                Toast.makeText(
                    requireContext(),
                    "Заполните все данные!",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val result =
                    weight.toDouble() / ((height.toDouble() / 100) * (height.toDouble() / 100))
                saveResult(result, binding.imtTV, 1)
            }
        }
    }
}