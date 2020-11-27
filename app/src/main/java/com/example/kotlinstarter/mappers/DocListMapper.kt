package com.example.kotlinstarter.mappers

import com.example.kotlinstarter.models.Doc
import com.example.kotlinstarter.models.PreviousDocs

internal fun List<Doc>.toPreviousDoc():PreviousDocs =
    PreviousDocs(
        this.iterator().next().id,
        this.iterator().next().article_type,
        this.iterator().next().eissn,
        this.iterator().next().journal,
        this.iterator().next().publication_date,
        this.iterator().next().score,
        this.iterator().next().title_display,
    )