package com.example.kotlinstarter.Database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PreviousDocsDao {
    //histories
    @Query("SELECT * FROM previous_articles")
    suspend fun getPreviousArticles():List<PreviousDocs>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllPreviousArticles(doc: PreviousDocs)
}