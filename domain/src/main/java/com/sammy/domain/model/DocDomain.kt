package com.sammy.domain.model

data class DocDomain(
    val `abstract`: List<String>,
    val article_type: String,
    val author_display: List<String>,
    val eissn: String,
    val id: String,
    val journal: String,
    val publication_date: String,
    val score: Double,
    val title_display: String
)