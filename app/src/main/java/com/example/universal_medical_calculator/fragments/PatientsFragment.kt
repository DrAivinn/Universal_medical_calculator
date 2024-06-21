package com.example.universal_medical_calculator.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.universal_medical_calculator.Patient
import com.example.universal_medical_calculator.PatientAdapterRV
import com.example.universal_medical_calculator.PatientViewModel
import com.example.universal_medical_calculator.databinding.FragmentPatientsBinding
import com.example.universal_medical_calculator.objects.AddPatientDialog
import com.example.universal_medical_calculator.objects.OnClickPatientDialog
import java.util.Locale

class PatientsFragment : FragmentBase<FragmentPatientsBinding>() {
    private val viewModel: PatientViewModel by activityViewModels<PatientViewModel>()
    private val patientAdapter = PatientAdapterRV { onClickItem(it) }
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPatientsBinding {
        return FragmentPatientsBinding.inflate(inflater, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.patientList.observe(viewLifecycleOwner) { list ->
            list?.let { patientAdapter.setData(it) }
            searchPatient(list)
        }
        with(binding) {
            patientRV.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            patientRV.adapter = patientAdapter
            addPatient.setOnClickListener {
                AddPatientDialog.showDialog(requireContext(), viewModel)
            }
        }
    }

    private fun searchPatient(list: List<Patient>) {
        val searchPatient: EditText = binding.searchET.editText as EditText
        searchPatient.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val searchText = s.toString().lowercase(Locale.getDefault())
                val filteredList = list.filter {
                    it.name.lowercase(Locale.getDefault()).contains(searchText)
                }
                patientAdapter.setData(filteredList)
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }


    private fun onClickItem(item: Patient) {
        OnClickPatientDialog.showDialog(requireContext(), item, viewModel, this)
    }

}