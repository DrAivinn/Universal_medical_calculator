package com.example.universal_medical_calculator

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
    @Query("SELECT name FROM patients")
    fun getAllPatientNames(): LiveData<List<String>>

    @Query("SELECT * FROM patients")
    fun getAllPatients(): LiveData<List<Patient>>

    @Insert
    suspend fun insert(patient: Patient)

    @Delete
    suspend fun delete(patient: Patient)

    @Query("DELETE FROM patients")
    suspend fun deleteAllData()

    @Update
    suspend fun update(patient: Patient)
}