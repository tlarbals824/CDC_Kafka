package com.asap.cdc_kafka.application.service

import com.asap.cdc_kafka.application.port.`in`.ArticleSaveUsecase
import com.asap.cdc_kafka.application.port.out.ArticleManagementPort
import com.asap.cdc_kafka.domain.Article
import org.springframework.stereotype.Service

@Service
class ArticleCommandService(
    private val articleManagementPort: ArticleManagementPort
): ArticleSaveUsecase {
    override fun save(command: ArticleSaveUsecase.Command) {
        articleManagementPort.save(
            Article(
                content = command.content
            )
        )
    }
}