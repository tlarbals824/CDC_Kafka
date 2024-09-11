package com.asap.cdc_kafka.presentation.dto

data class ArticleSearchResponse(
    val articles: List<ArticleInfo>
) {

    data class ArticleInfo(
        val id: Long,
        val content: String
    )
}