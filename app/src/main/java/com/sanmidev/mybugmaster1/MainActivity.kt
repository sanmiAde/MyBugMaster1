package com.sanmidev.mybugmaster1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sanmidev.mybugmaster1.databinding.ActivityMainBinding
import com.sanmidev.mybugmaster1.utils.JsonUtils
import org.json.JSONObject;

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private  var _activityMainBinding : ActivityMainBinding? = null

    val activityMainBinding : ActivityMainBinding
        get() = _activityMainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.txtName.text = readFileFromRawDirectory(R.raw.insects)


      val insectList =  JsonUtils.convertJsonToInsects(readFileFromRawDirectory(R.raw.insects))

        insectList.forEach {
            Log.d("main", it.toString())
        }

    }

    private fun readFileFromRawDirectory(resourceId: Int): String {
        val iStream: InputStream = resources.openRawResource(resourceId)
        var byteStream: ByteArrayOutputStream? = null
        try {
            val buffer = ByteArray(iStream.available())
            iStream.read(buffer)
            byteStream = ByteArrayOutputStream()
            byteStream.write(buffer)
            byteStream.close()
            iStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return byteStream.toString()
    }


    override fun onDestroy() {
        _activityMainBinding = null
        super.onDestroy()
    }
}
