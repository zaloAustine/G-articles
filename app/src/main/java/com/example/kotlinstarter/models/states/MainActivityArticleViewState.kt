package com.example.kotlinstarter.models.states

import com.example.kotlinstarter.models.DocPresenter

data class MainActivityArticleViewState(
    val isLoading: Boolean,
    val error: Error?,
    val articleResults: List<DocPresenter>?
)