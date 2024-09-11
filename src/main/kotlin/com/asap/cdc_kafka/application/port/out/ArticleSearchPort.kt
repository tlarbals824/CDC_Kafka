package com.asap.cdc_kafka.application.port.out

import com.asap.cdc_kafka.domain.Article

interface ArticleSearchPort {

    fun searchArticle(
        content: String
    ): List<Article>
}