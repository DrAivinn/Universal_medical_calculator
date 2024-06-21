package com.example.universal_medical_calculator.objects

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.universal_medical_calculator.Patient
import com.example.universal_medical_calculator.PatientViewModel
import com.example.universal_medical_calculator.databinding.DialogAddPatientBinding

object AddPatientDialog {
    fun showDialog(requireContext: Context, viewModel: PatientViewModel) {
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(requireContext)
        val binding = DialogAddPatientBinding.inflate(LayoutInflater.from(requireContext))
        builder.setView(binding.root)
        with(binding) {
            cancelBTN.setOnClickListener { dialog?.cancel() }
            addBTN.setOnClickListener {
                val name = nameTIL.editText?.text.toString()
                val age = ageTIL.editText?.text.toString()
                if (name.isEmpty() || age.isEmpty()) {
                    Toast.makeText(
                        requireContext,
                        "Заполните все данные о пациенте!",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    return@setOnClickListener
                } else {
                    viewModel.insert(Patient(name, age))
                }
                dialog?.cancel()
            }
        }
        dialog = builder.create()
        dialog.show()
    }
}
