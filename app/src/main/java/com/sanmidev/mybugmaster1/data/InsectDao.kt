package com.sanmidev.mybugmaster1.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface InsectDao {

    @Query(" DELETE  from  insect_table")
    suspend fun deleteAll()

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insertInsects(insects : List<Insect>)

    @Query("SELECT * from insect_table ORDER BY friendlyName ASC")
    fun getAllInsects() : LiveData<List<Insect>>


}