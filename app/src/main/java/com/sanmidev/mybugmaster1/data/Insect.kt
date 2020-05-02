package com.sanmidev.mybugmaster1.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "insect_table")
data class Insect(
    @PrimaryKey
    val friendlyName : String,
    val scientificName : String,
    val classification : String,
    val imageAsset : String,
    val dangerLevel :String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(friendlyName)
        parcel.writeString(scientificName)
        parcel.writeString(classification)
        parcel.writeString(imageAsset)
        parcel.writeString(dangerLevel)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Insect> {
        override fun createFromParcel(parcel: Parcel): Insect {
            return Insect(parcel)
        }

        override fun newArray(size: Int): Array<Insect?> {
            return arrayOfNulls(size)
        }
    }
}