package com.gailo22.hellospringwebflux.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/rx/hello")
    fun helloRx() = "hello"
}