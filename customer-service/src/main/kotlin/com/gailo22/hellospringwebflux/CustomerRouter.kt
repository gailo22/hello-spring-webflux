package com.gailo22.hellospringwebflux

import com.gailo22.hellospringwebflux.model.Customer
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.toMono

@Component
class CustomerRouter {

    @Bean
    fun customerRoutes() =
        router {
            "/functional".nest {
                "/customers".nest {
                    GET("/") {
                        ok().body(
                                Customer(10, "God", "god@email.com").toMono(),
                                Customer::class.java
                        )
                    }
                }
            }
        }
}