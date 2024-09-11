package com.asap.cdc_kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CdcKafkaApplication

fun main(args: Array<String>) {
    runApplication<CdcKafkaApplication>(*args)
}
