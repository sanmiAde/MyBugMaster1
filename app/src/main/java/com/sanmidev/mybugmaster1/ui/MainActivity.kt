package com.sanmidev.mybugmaster1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanmidev.mybugmaster1.databinding.ActivityMainBinding
import com.sanmidev.mybugmaster1.ui.insectList.InsectAdapter

class MainActivity : AppCompatActivity() {

    private  var _activityMainBinding : ActivityMainBinding? = null
    private var adapter : InsectAdapter? = null

    private val activityMainBinding : ActivityMainBinding
        get() = _activityMainBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

    }




    override fun onDestroy() {
        _activityMainBinding = null
        adapter = null
        super.onDestroy()
    }
}
