package com.example.kotlinstarter.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class Doc(
    @PrimaryKey
    var id: String  = "0",
    val article_type: String?,
    val eissn: String?,
    val journal: String?,
    val publication_date: String?,
    val score: Double?,
    val title_display: String?,
)