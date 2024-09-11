package com.asap.cdc_kafka.worker.common

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.stereotype.Component

@Component
class ConnectParser(
    private val objectMapper: ObjectMapper
) {


    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class ConnectMessage<T>(
        val schema: Schema,
        val payload: T
    )

    data class Schema(
        val type: String,
        val fields: List<Field>
    )
    data class Field(
        val type: String,
        val optional: Boolean,
        val field: String,
    )


}