package com.sammy.data_remote.api

import com.sammy.data_remote.model.ArticleData
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesApi {
    @GET("search")
    suspend fun getArticles(
        @Query("q") title: String
    ): ArticleData
}