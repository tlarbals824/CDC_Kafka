package com.asap.cdc_kafka.infrastructure.es

import com.asap.cdc_kafka.application.port.out.ArticleSearchPort
import com.asap.cdc_kafka.domain.Article
import org.springframework.stereotype.Repository

@Repository
class ArticleElasticSearchAdapter(
    private val articleElasticSearchRepository: ArticleElasticSearchRepository
): ArticleSearchPort {
    override fun searchArticle(content: String): List<Article> {
        return articleElasticSearchRepository.findAllByContentContains(content).map {
            Article(
                id = it.id,
                content = it.content
            )
        }
    }
}