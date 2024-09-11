package com.asap.cdc_kafka.application.service

import com.asap.cdc_kafka.application.port.`in`.ArticleSearchUsecase
import com.asap.cdc_kafka.application.port.out.ArticleSearchPort
import org.springframework.stereotype.Service

@Service
class ArticleQueryService(
    private val articleSearchPort: ArticleSearchPort
) : ArticleSearchUsecase {
    override fun searchArticle(query: ArticleSearchUsecase.Query): ArticleSearchUsecase.Response {
        return ArticleSearchUsecase.Response(
            articles = articleSearchPort.searchArticle(query.content).map {
                ArticleSearchUsecase.ArticleInfo(
                    id = it.id,
                    content = it.content
                )
            }
        )
    }
}