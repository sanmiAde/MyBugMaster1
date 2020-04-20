package com.sanmidev.mybugmaster1.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "insect_table")
data class Insect(
    @PrimaryKey
    val friendlyName : String,
    val scientificName : String,
    val classification : String,
    val imageAsset : String,
    val dangerLevel :String) {
}