package com.sanmidev.mybugmaster1.data

import androidx.room.Entity

@Entity("insect_table")
data class Insect(val friendlyName : String, val scientificName : String, val classification : String, val imageAsset : String, val dangerLevel :String) {
}