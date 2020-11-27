package com.example.kotlinstarter.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "previous_articles")
data class PreviousDocs(
    @PrimaryKey
    var id: String  = "0",
    val article_type: String?,
    val eissn: String?,
    val journal: String?,
    val publication_date: String?,
    val score: Double?,
    val title_display: String?,
)
