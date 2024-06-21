package com.example.universal_medical_calculator

class Repository(val dao: Dao) {
    val patientList = dao.getAllPatients()
    val patientNameList = dao.getAllPatientNames()
    suspend fun insert(patient: Patient) {
        dao.insert(patient)
    }

    suspend fun delete(patient: Patient) {
        dao.delete(patient)
    }

    suspend fun update(patient: Patient) {
        dao.update(patient)
    }
    suspend fun deleteAllData(){
        dao.deleteAllData()
    }
}
