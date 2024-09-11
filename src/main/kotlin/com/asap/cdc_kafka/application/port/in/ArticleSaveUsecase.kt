package com.asap.cdc_kafka.application.port.`in`

interface ArticleSaveUsecase {

    fun save(
        command: Command
    )

    data class Command(
        val content: String
    )


}