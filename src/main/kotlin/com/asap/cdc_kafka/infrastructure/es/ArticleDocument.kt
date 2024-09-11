package com.asap.cdc_kafka.infrastructure.es

import org.springframework.data.elasticsearch.annotations.FieldType
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field

@Document(indexName = "article")
class ArticleDocument(
    id: Long,
    content: String
) {
    @Id
    @Field(
        type = FieldType.Long,
        name = "id"
    )
    val id = id

    @Field(
        type = FieldType.Text,
        name = "content"
    )
    val content = content
}