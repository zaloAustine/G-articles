package com.sammy.data_remote.model

data class Response(
    val docs: List<Doc>,
    val maxScore: Double,
    val numFound: Int,
    val start: Int
)