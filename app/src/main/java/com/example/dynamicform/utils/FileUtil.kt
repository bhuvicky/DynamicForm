package com.example.dynamicform.utils

import android.content.Context
import com.example.dynamicform.data.FormPage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

object FileUtil {

    inline fun getAssetJsonData(context: Context, jsonFileName: String, cb: (list: List<FormPage>) -> Unit)  {
        lateinit var json: String
        try {
            val inputStream = context.getAssets().open(jsonFileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.use { it.read(buffer) }
            json = String(buffer)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            json = ""
        }
        // ERROR: public inline func cannot access private fun "pareseJson"
        cb( parseJson(json))
    }

     fun parseJson(data: String): List<FormPage> {
        val gson = Gson()
        val jsonOutput = data
        val listType = object : TypeToken<List<FormPage?>?>() {}.type
        val noOfPage: List<FormPage> = gson.fromJson(jsonOutput, listType)
        println("log no of page = ${noOfPage.size}")
        return noOfPage
    }
}