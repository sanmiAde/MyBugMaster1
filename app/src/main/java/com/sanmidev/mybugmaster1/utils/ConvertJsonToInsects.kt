package com.sanmidev.mybugmaster1.utils

import android.content.Context
import com.sanmidev.mybugmaster1.data.Insect
import org.json.JSONArray
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream

object JsonUtils {
    private const val INSECTS_LIST = "insects"
    private const val FRIENDLY_NAME = "friendlyName"
    private const val SCIENTIFIC_NAME = "scientificName"
    private const val CLASSIFICATION = "classification"
    private const val IMAGE_ASSET = "imageAsset"
    private const val DANGER_LEVEL = "dangerLevel"

    /****
     * Convert json file read to a list of insect object.
     * @param jsonString from the res folder.
     * @return lis of insect.
     */
    fun convertJsonToInsects(jsonString: String): List<Insect> {
        val insectJSONObject = JSONObject(jsonString)
        val insectArray: JSONArray = insectJSONObject.getJSONArray("insects")
        val listOFInsects = mutableListOf<Insect>()


        for (index in 1 until insectArray.length()) {
            val insectJSONObject: JSONObject = insectArray.getJSONObject(index)

            val insect = Insect(
                insectJSONObject.getString(FRIENDLY_NAME), insectJSONObject.getString(
                    SCIENTIFIC_NAME
                ), insectJSONObject.getString(CLASSIFICATION), insectJSONObject.getString(
                    IMAGE_ASSET
                ), insectJSONObject.getString(DANGER_LEVEL)
            )

            listOFInsects.add(insect)
        }

        return listOFInsects
    }


     fun readFileFromRawDirectory(context: Context, resourceId: Int): String {
        val iStream: InputStream = context.resources.openRawResource(resourceId)
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
}