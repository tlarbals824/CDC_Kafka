package com.asap.cdc_kafka.infrastructure.jpa

import com.asap.cdc_kafka.application.port.out.ArticleManagementPort
import com.asap.cdc_kafka.domain.Article
import org.springframework.stereotype.Repository

@Repository
class ArticleJpaManagementAdapter(
    private val articleJpaRepository: ArticleJpaRepository
): ArticleManagementPort {
    override fun save(article: Article): Article {
        return articleJpaRepository.save(
            ArticleEntity(
                id = article.id,
                content = article.content
            )
        ).toDomain()
    }
}