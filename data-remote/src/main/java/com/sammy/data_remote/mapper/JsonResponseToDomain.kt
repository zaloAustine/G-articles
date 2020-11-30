package com.sammy.data_remote.mapper

import com.sammy.data_remote.model.Doc
import com.sammy.domain.model.DocDomain

internal fun Doc.toDomain():DocDomain =
    DocDomain(
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