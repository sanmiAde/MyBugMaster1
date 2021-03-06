package com.sanmidev.mybugmaster1.ui.insectList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanmidev.mybugmaster1.data.Insect
import com.sanmidev.mybugmaster1.data.InsectRepository
import com.sanmidev.mybugmaster1.data.MyBugMasterDatabase

class InsectListViewModel (val app: Application) : AndroidViewModel(app) {

    private val insectRepository : InsectRepository

    val allInsects : LiveData<List<Insect>>

    init {
        val mybugDatabase = MyBugMasterDatabase.getDatabase(app, viewModelScope)
        insectRepository = InsectRepository(mybugDatabase.insectDao)
        allInsects = insectRepository.getInsectList()
    }
}
