package com.sanmidev.mybugmaster1.ui

import android.app.Activity
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.sanmidev.mybugmaster1.R

fun initToolbarButton( title : String,  toolbar: Toolbar, setBackButton : Boolean = true,  activity: Activity) {
    toolbar.title = title

    if(setBackButton){
        toolbar.setNavigationIcon(
            R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener {
            (activity as MainActivity).onBackPressed()
        }
    }



}
