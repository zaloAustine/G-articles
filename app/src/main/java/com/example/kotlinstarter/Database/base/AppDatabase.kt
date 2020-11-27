package com.example.kotlinstarter.Database.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kotlinstarter.Database.Dao.ArticleDao
import com.example.kotlinstarter.Database.Dao.PreviousDocsDao
import com.example.kotlinstarter.models.Doc
import com.example.kotlinstarter.models.PreviousDocs
import com.example.kotlinstarter.utils.StringDocConverter
import com.example.kotlinstarter.utils.StringListConverter

@Database(entities = arrayOf(Doc::class,PreviousDocs::class), version = 1)
@TypeConverters(StringListConverter::class,StringDocConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
    abstract fun previousDocsDao():PreviousDocsDao
}
