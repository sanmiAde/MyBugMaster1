package com.sanmidev.mybugmaster1.ui

import android.os.Bundle
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sanmidev.mybugmaster1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  var _activityMainBinding : ActivityMainBinding? = null
    private var adapter : InsectAdapter? = null

    val activityMainBinding : ActivityMainBinding
        get() = _activityMainBinding!!

    private val mainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        val adapter = InsectAdapter(this)
        activityMainBinding.insectListRecyclerview.adapter = adapter
        activityMainBinding.insectListRecyclerview.layoutManager = LinearLayoutManager(this)
        mainViewModel.allInsects.observe(this, Observer {
            adapter.setInsectList(it)
        })


    }




    override fun onDestroy() {
        _activityMainBinding = null
        adapter = null
        super.onDestroy()
    }
}
