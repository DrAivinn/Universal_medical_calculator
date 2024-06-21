package com.example.universal_medical_calculator.fragments

import android.R
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import com.example.universal_medical_calculator.PatientViewModel

abstract class BaseCalculatorFragment<T : ViewBinding> : FragmentBase<T>() {
    private val viewModel by activityViewModels<PatientViewModel>()
    var patientPosition = 0

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): T {
        TODO("Not yet implemented")
    }

    @SuppressLint("DefaultLocale")
    fun saveResult(result: Double, textView: TextView, key: Int) {
        val formatResult = String.format("%.1f", result)
        textView.text = formatResult
        viewModel.patientList.observe(viewLifecycleOwner) { list ->
            if (list.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Нужно зарегистрировать пациента",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val patient = list[patientPosition]
                when (key) {
                    1 -> patient.imt = formatResult
                    2 -> patient.drugInfusionRate = formatResult
                    3 -> patient.potassiumDeficiency = formatResult
                    4 -> patient.drugSpeed = formatResult
                }
                viewModel.update(patient)
            }
        }
    }

    fun initSpinner(spinner: Spinner) {
        viewModel.patientNameList.observe(viewLifecycleOwner) { list ->
            val spinnerAdapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, list)
            spinnerAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinner.adapter = spinnerAdapter
            spinner.setSelection(patientPosition)
        }
        val itemSpinnerSelected = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val value = parent?.getItemAtPosition(position)
                patientPosition = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        spinner.onItemSelectedListener = itemSpinnerSelected
    }
}


