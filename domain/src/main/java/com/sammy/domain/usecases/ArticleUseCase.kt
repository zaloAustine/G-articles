package com.sammy.domain.usecases

import com.sammy.domain.model.DocDomain
import com.sammy.domain.repository.IArticlesRepository
import kotlinx.coroutines.flow.Flow

typealias ArticleBaseUseCase = BaseUseCase<String, Flow<List<DocDomain>>>

class ArticleUseCase(
    private val articleRepository: IArticlesRepository
):ArticleBaseUseCase {
    override suspend fun invoke(parameter: String): Flow<List<DocDomain>>  =
        articleRepository.getArticles(parameter)
}