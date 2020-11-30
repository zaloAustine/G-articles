package com.example.kotlinstarter.di

import com.sammy.data_remote.repository.ArticleRepository
import com.sammy.domain.repository.IArticlesRepository
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<IArticlesRepository>{ArticleRepository(articlesApi = get())}
}