package com.sanmidev.mybugmaster1.utils

import com.sanmidev.mybugmaster1.data.Insect
import org.json.JSONArray
import org.json.JSONObject

object JsonUtils {
    private const val INSECTS_LIST = "insects"
    private const val FRIENDLY_NAME = "friendlyName"
    private const val SCIENTIFIC_NAME = "scientificName"
    private const val CLASSIFICATION = "classification"
    private const val IMAGE_ASSET = "imageAsset"
    private const val DANGER_LEVEL = "dangerLevel"

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
}