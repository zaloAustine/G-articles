package com.example.kotlinstarter.utils

import androidx.room.TypeConverter
import com.example.kotlinstarter.models.Doc
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringDocConverter {

    /**Convert string to list*/
    @TypeConverter
    fun stringToIntList(data: String): List<Doc> {
        val type = object : TypeToken<List<Doc>>() {}.type
        return Gson().fromJson(data, type)
    }


    /**Convert list to string*/
    @TypeConverter
    fun intListToString(genreIds: List<Doc>): String {
        return Gson().toJson(genreIds)
    }

}