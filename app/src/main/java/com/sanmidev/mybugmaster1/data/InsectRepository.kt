package com.sanmidev.mybugmaster1.data

import androidx.lifecycle.LiveData

class InsectRepository(private val insectDao: InsectDao) {



    fun getInsectList() : LiveData<List<Insect>>{
        return  insectDao.getAllInsects()
    }
}