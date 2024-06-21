package com.example.universal_medical_calculator

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Patient::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {
        @Volatile()
        private var database: DataBase? = null
        fun getDataBase(context: Context): DataBase {
            return database ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,"db"
                ).build()
                database = instance
                instance
            }
        }
    }
}