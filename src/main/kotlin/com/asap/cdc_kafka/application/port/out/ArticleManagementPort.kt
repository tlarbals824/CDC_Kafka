package com.asap.cdc_kafka.application.port.out

import com.asap.cdc_kafka.domain.Article

interface ArticleManagementPort {

    fun save(article: Article): Article
}