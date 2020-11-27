package com.example.kotlinstarter.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringListConverter {

    /**Convert string to list*/
    @TypeConverter
    fun stringToIntList(data: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(data, type)
    }

    /**Convert list to string*/
    @TypeConverter
    fun intListToString(genreIds: List<String>): String {
        return Gson().toJson(genreIds)
    }

}