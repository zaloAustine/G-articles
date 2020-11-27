package com.example.kotlinstarter.di

import com.example.kotlinstarter.objects.HttpClient
import com.example.kotlinstarter.objects.LoggingInterceptor
import com.example.kotlinstarter.services.MainActivityApiService
import com.example.kotlinstarter.objects.MoshiCreator
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class MainActivityDiModule{

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = MoshiCreator.create()

    @Provides
    fun provideLoggingInterceptor() = LoggingInterceptor.create()

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        HttpClient.create(httpLoggingInterceptor)

    @Named("BaseUrl")
    @Provides
    fun getBaseUrl():String = "https://api.plos.org/"

    @Singleton
    @Named("retrofit")
    @Provides
    fun provideRetrofit(
        moshi: Moshi,
        @Named("BaseUrl")baseUrl: String,
        okHttpClient: OkHttpClient
    ):Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }


    @Singleton
    @Named("foodApi")
    @Provides
    fun provideMainActivityApi(@Named("retrofit") retrofit: Retrofit): MainActivityApiService =
        retrofit.create(MainActivityApiService::class.java)



}

