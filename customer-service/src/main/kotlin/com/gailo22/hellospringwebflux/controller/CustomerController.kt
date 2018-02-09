package com.gailo22.hellospringwebflux.controller

import com.gailo22.hellospringwebflux.model.Customer
import com.gailo22.hellospringwebflux.model.CustomerDto
import com.gailo22.hellospringwebflux.model.toDto
import com.gailo22.hellospringwebflux.model.toObject
import com.gailo22.hellospringwebflux.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import org.springframework.web.bind.annotation.PostMapping
import reactor.core.publisher.toMono

@RestController
@RequestMapping("/rx")
class CustomerController(
        val customerService: CustomerService
) {

    @GetMapping("/customers")
    fun getAll(): Mono<List<CustomerDto>> {
        return customerService.getCustomers()
                .map { it.toDto() }
                .toMono()
    }

    @GetMapping("/customers/{id}")
    fun get(@PathVariable id: Int): Mono<*> {
        return customerService.getCustomer(id)
    }

    @PostMapping("/customers")
    fun save(@RequestBody customerMono: Mono<CustomerDto>): ResponseEntity<Mono<Customer>> {
        return ResponseEntity(
                customerMono.flatMap {
                    customerService.saveCustomer(it.toObject())
                },
                HttpStatus.CREATED
        )
    }

    @PostMapping("/customers/{id}/name")
    fun processSubmit(@RequestBody custMono: Mono<CustomerDto>): Mono<String> {
        return custMono.map { c -> c.name }.toMono()
    }
}