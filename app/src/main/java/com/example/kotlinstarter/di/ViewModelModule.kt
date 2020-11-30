package com.example.kotlinstarter.di

import com.example.kotlinstarter.viewmodels.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainActivityViewModel(
            articleUseCase = get(named("articles"))
        )
    }
}