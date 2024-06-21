package com.example.universal_medical_calculator.objects

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.universal_medical_calculator.Patient
import com.example.universal_medical_calculator.PatientViewModel
import com.example.universal_medical_calculator.R
import com.example.universal_medical_calculator.databinding.DialogPatientBinding
import com.example.universal_medical_calculator.fragments.PatientsFragment

object OnClickPatientDialog {
    fun showDialog(
        requireContext: Context,
        item: Patient,
        viewModel: PatientViewModel,
        fragment: PatientsFragment
    ) {
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(requireContext)
        val binding = DialogPatientBinding.inflate(LayoutInflater.from(requireContext))
        builder.setView(binding.root)
        with(binding) {
            toolbar.title = "Пациент: ${item.name}"
            cancelBTN.setOnClickListener { dialog?.cancel() }
            deleteAllDataBTN.setOnClickListener {
                viewModel.deleteAllData()
                dialog?.cancel()
            }
            deleteBTN.setOnClickListener {
                viewModel.delete(item)
                dialog?.cancel()
            }
            infoBTN.setOnClickListener {
                val bundle = Bundle()
                bundle.putParcelable("item", item)
                findNavController(fragment).navigate(
                    R.id.action_patientsFragment_to_patientInfoFragment,
                    bundle
                )
                dialog?.cancel()
            }
        }
        dialog = builder.create()
        dialog.show()
    }
}
