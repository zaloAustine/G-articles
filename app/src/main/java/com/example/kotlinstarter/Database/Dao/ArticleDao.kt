package com.example.kotlinstarter.Database.Dao

import androidx.room.*

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles")
    suspend fun getArticles():List<Doc>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllArticles(doc: List<Doc>)

    @Query("DELETE FROM articles")
    fun deleteArticles()

}