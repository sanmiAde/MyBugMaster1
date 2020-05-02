package com.sanmidev.mybugmaster1.ui.insectdetail

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter{

    @JvmStatic
    @BindingAdapter("bind_insect_picture")
    fun ImageView.bindPInsectPictureName(pictureName : String){
            val pictureNameWithoutExtension = pictureName.substringBefore(".png")
            this.setImageResource(this.context.resIdByName(pictureNameWithoutExtension,"drawable"))
    }

    fun Context.resIdByName(resIdName: String?, resType: String): Int {
        resIdName?.let {
            Log.d("BindingAdapter", resources.getIdentifier(it, resType, packageName).toString())
            return resources.getIdentifier(it, resType, packageName)
        }
        throw Resources.NotFoundException()
    }
}
