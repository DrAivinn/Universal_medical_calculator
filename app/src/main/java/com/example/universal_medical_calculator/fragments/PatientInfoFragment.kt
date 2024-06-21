package com.example.universal_medical_calculator.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.universal_medical_calculator.Patient
import com.example.universal_medical_calculator.databinding.FragmentPatientInfoBinding

class PatientInfoFragment : FragmentBase<FragmentPatientInfoBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentPatientInfoBinding {
        return FragmentPatientInfoBinding.inflate(inflater, container, false)
    }

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val patient = arguments?.getParcelable("item", Patient::class.java)
        val patientInfoNameText = "Ф.И.О: ${patient!!.name}\n\nВозраст: ${patient.age}"
        binding.patientInfoName.text = patientInfoNameText
        val imt = if (patient.imt == "") "" else "ИМТ: ${patient.imt}"
        val drugInfusionRate =
            if (patient.drugInfusionRate == "") "" else "Скорость инфузии препарата: ${patient.drugInfusionRate} мл/час"
        val potassiumDeficiency =
            if (patient.potassiumDeficiency == "") "" else "Дефицит калия: ${patient.potassiumDeficiency} моль/л"
        val drugSpeed =
            if (patient.drugSpeed == "") "" else "Скорость внутривенного капельного введения препарата: ${patient.drugSpeed} капель в минуту"
        val patientInfoDescriptionText =
            "$imt\n\n$drugInfusionRate\n\n$potassiumDeficiency\n\n$drugSpeed"
        binding.patientInfoDescription.text = patientInfoDescriptionText
    }
}