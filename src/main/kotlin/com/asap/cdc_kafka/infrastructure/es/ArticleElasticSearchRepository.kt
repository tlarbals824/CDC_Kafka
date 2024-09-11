package com.asap.cdc_kafka.infrastructure.es

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface ArticleElasticSearchRepository: ElasticsearchRepository<ArticleDocument, Long> {

    fun findAllByContentContains(content: String): List<ArticleDocument>

}