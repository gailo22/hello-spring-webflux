package com.gailo22.hellospringwebflux.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice
class ExceptionController

data class ApiError(val status: HttpStatus, val errors: List<String>?)
