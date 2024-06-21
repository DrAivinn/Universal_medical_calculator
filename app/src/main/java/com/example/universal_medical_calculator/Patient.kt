package com.example.universal_medical_calculator

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patients")
data class Patient(

    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") var age: String,
    @ColumnInfo(name = "imt") var imt: String = "",
    @ColumnInfo(name = "drug_infusion_rate") var drugInfusionRate: String = "",
    @ColumnInfo(name = "potassium_deficiency") var potassiumDeficiency: String = "",
    @ColumnInfo(name = "drug_speed") var drugSpeed: String = "",
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(age)
        parcel.writeString(imt)
        parcel.writeString(drugInfusionRate)
        parcel.writeString(potassiumDeficiency)
        parcel.writeString(drugSpeed)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Patient> {
        override fun createFromParcel(parcel: Parcel): Patient {
            return Patient(parcel)
        }

        override fun newArray(size: Int): Array<Patient?> {
            return arrayOfNulls(size)
        }
    }
}