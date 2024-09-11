package com.asap.cdc_kafka.application.port.`in`

import com.asap.cdc_kafka.presentation.dto.ArticleSearchResponse

interface ArticleSearchUsecase {

    fun searchArticle(
        query: Query
    ): Response


    data class Query(
        val content: String
    )

    data class Response(
        val articles: List<ArticleInfo>
    )

    data class ArticleInfo(
        val id: Long,
        val content: String
    )
}