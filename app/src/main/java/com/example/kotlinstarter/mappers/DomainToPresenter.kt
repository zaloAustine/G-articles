package com.example.kotlinstarter.mappers

import com.example.kotlinstarter.models.DocPresenter
import com.sammy.domain.model.DocDomain

internal fun DocDomain.toPresenter():DocPresenter =
    DocPresenter(
        this.abstract,
        this.article_type,
        this.author_display,
        this.eissn,
        this.id,
        this.journal,
        this.publication_date,
        this.score,
        this.title_display
    )