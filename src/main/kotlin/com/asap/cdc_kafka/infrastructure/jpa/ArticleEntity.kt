package com.asap.cdc_kafka.infrastructure.jpa

import com.asap.cdc_kafka.domain.Article
import jakarta.persistence.*

@Entity
@Table(name = "article")
class ArticleEntity(
    id: Long,
    content: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = id

    @Column(
        name = "content",
        columnDefinition = "TEXT",
        nullable = false
    )
    val content: String = content

    @Column(
        name = "is_deleted",
        nullable = false
    )
    val isDeleted: Boolean = false


    fun toDomain(): Article {
        return Article(
            id = this.id,
            content = this.content
        )
    }
}