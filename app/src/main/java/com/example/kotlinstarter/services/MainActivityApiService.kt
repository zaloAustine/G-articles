package com.example.kotlinstarter.services

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface MainActivityApiService {

    @GET("search")
    fun getDna(
        @Query("q") title:String
    ): Deferred<DnaResponse>

}


