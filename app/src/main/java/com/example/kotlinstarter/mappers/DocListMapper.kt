package com.example.kotlinstarter.mappers

import com.example.kotlinstarter.models.Doc
import com.example.kotlinstarter.models.PreviousDocs

internal fun Doc.toPreviousDoc():PreviousDocs =
     PreviousDocs(
        this.id,
        this.article_type,
        this.eissn,
        this.journal,
        this.publication_date,
        this.score,
        this.title_display
    )