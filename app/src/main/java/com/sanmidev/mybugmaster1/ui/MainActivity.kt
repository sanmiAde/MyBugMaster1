package com.sanmidev.mybugmaster1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sanmidev.mybugmaster1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  var _activityMainBinding : ActivityMainBinding? = null

    val activityMainBinding : ActivityMainBinding
        get() = _activityMainBinding!!

    private val mainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        mainViewModel.allInsects.observe(this, Observer {
            activityMainBinding.txtName.text = it.toString()
        })


    }




    override fun onDestroy() {
        _activityMainBinding = null
        super.onDestroy()
    }
}
