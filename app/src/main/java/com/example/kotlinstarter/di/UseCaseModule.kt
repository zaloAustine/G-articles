package com.example.kotlinstarter.di

import com.sammy.domain.repository.IArticlesRepository
import com.sammy.domain.usecases.ArticleBaseUseCase
import com.sammy.domain.usecases.ArticleUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {
    single(named("articles")) { provideArticleUseCase(get())  }
}
internal fun provideArticleUseCase(iArticlesRepository: IArticlesRepository):ArticleBaseUseCase =
    ArticleUseCase(iArticlesRepository)