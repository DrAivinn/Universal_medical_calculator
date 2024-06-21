package com.example.universal_medical_calculator

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.universal_medical_calculator.databinding.ItemPatientBinding

class PatientAdapterRV(val onClick: (Patient) -> Unit) :
    RecyclerView.Adapter<PatientAdapterRV.PatientViewHolder>() {
    private var list = emptyList<Patient>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Patient>) {
        list = data
        notifyDataSetChanged()
    }

    class PatientViewHolder(val binding: ItemPatientBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val binding = ItemPatientBinding.inflate(LayoutInflater.from(parent.context))
        return PatientViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            itemName.text = item.name
            val age = "Возраст: ${item.age}"
            itemAge.text = age
            root.setOnClickListener { onClick(item) }
        }
    }
}