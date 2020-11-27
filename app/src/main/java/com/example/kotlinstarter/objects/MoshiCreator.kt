package com.example.kotlinstarter.objects

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiCreator{

    fun create(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}

