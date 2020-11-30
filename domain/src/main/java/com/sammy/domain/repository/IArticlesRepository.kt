package com.sammy.domain.repository

import com.sammy.domain.model.DocDomain
import kotlinx.coroutines.flow.Flow

interface IArticlesRepository {
    suspend fun getArticles(search:String): Flow<List<DocDomain>>
}