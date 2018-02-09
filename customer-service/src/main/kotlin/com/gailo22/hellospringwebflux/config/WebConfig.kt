package com.gailo22.hellospringwebflux.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.gailo22.hellospringwebflux.service.CustomerService
import com.gailo22.hellospringwebflux.service.CustomerServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.reactive.config.EnableWebFlux

@Configuration
@EnableWebFlux
class WebConfig

@Primary
@Bean
fun objectMapper() = ObjectMapper().apply {
    registerModule(KotlinModule())
}
