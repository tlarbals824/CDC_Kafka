package com.asap.cdc_kafka.infrastructure.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface ArticleJpaRepository: JpaRepository<ArticleEntity, Long> {
}