package com.gailo22.hellospringwebflux.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(message: String?) : Exception(message) {
    constructor(): this("")
}