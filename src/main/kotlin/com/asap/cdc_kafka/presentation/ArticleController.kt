package com.asap.cdc_kafka.presentation

import com.asap.cdc_kafka.application.port.`in`.ArticleSaveUsecase
import com.asap.cdc_kafka.application.port.`in`.ArticleSearchUsecase
import com.asap.cdc_kafka.presentation.dto.ArticleSearchRequest
import com.asap.cdc_kafka.presentation.dto.ArticleSearchResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/articles")
class ArticleController(
    private val articleSearchUsecase: ArticleSearchUsecase,
    private val articleSaveUsecase: ArticleSaveUsecase
) {


    @GetMapping
    fun searchArticle(
        @RequestParam content: String
    ): ArticleSearchResponse {
        val response = articleSearchUsecase.searchArticle(
            ArticleSearchUsecase.Query(
                content = content
            )
        )
        return ArticleSearchResponse(
            articles = response.articles.map {
                ArticleSearchResponse.ArticleInfo(
                    id = it.id,
                    content = it.content
                )
            }
        )
    }

    @PostMapping
    fun saveArticle(
        @RequestBody request: ArticleSearchRequest
    ){
        articleSaveUsecase.save(
            ArticleSaveUsecase.Command(
                content = request.content
            )
        )
    }

}