package com.sammy.data_remote.repository

import com.sammy.data_remote.api.ArticlesApi
import com.sammy.domain.model.DocDomain
import com.sammy.domain.repository.IArticlesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ArticleRepository(
    private val articlesApi: ArticlesApi
):IArticlesRepository {
    override suspend fun getCurrentLocation(search: String): Flow<List<DocDomain>> = flow {
        val result = articlesApi.getArticles(title = search)
        val articleList = mutableListOf<DocDomain>()
        result.response.forEach {  article ->
            articleList.add(article)
        }
        emit(articleList)
    }
}