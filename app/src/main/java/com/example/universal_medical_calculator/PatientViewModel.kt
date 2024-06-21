package com.example.universal_medical_calculator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PatientViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository
    var patientList: LiveData<List<Patient>>
    var patientNameList: LiveData<List<String>>

    init {
        val dao = DataBase.getDataBase(application).getDao()
        repository = Repository(dao)
        patientList = repository.patientList
        patientNameList = repository.patientNameList
    }


    fun insert(patient: Patient) {
        viewModelScope.launch(Dispatchers.IO) { repository.insert(patient) }
    }

    fun delete(patient: Patient) {
        viewModelScope.launch(Dispatchers.IO) { repository.delete(patient) }
    }

    fun update(patient: Patient) {
        viewModelScope.launch(Dispatchers.IO) { repository.update(patient) }
    }

    fun deleteAllData() {
        viewModelScope.launch(Dispatchers.IO) { repository.deleteAllData() }
    }

}