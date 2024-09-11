package com.asap.cdc_kafka.worker.article

import com.asap.cdc_kafka.worker.common.ConnectParser
import com.asap.cdc_kafka.infrastructure.es.ArticleDocument
import com.asap.cdc_kafka.infrastructure.es.ArticleElasticSearchRepository
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ArticleConsumer(
    private val connectParser: ConnectParser,
    private val objectMapper: ObjectMapper,
    private val articleElasticSearchRepository: ArticleElasticSearchRepository
) {

    @KafkaListener(
        topics = ["livid_article"],
        groupId = "article-consumer-group",
    )
    fun consume(message: ConsumerRecord<String, String>) {
        message.value()?.let {
            val article = objectMapper.readValue<ConnectParser.ConnectMessage<Article>>(it).payload
            if (article.isDeleted) {
                articleElasticSearchRepository.deleteById(article.id)
            } else {
                articleElasticSearchRepository.save(
                    ArticleDocument(
                        id = article.id,
                        content = article.content
                    )
                )
            }
        }
    }


    data class Article(
        val id: Long,
        val content: String,
        @field:JsonProperty("is_deleted")
        val isDeleted: Boolean
    )
}