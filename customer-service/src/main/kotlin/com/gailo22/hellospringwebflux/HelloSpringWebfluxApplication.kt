package com.gailo22.hellospringwebflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloSpringWebfluxApplication

fun main(args: Array<String>) {
    runApplication<HelloSpringWebfluxApplication>(*args)
}
