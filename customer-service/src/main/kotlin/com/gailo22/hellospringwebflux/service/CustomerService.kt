package com.gailo22.hellospringwebflux.service

import com.gailo22.hellospringwebflux.model.Customer
import com.gailo22.hellospringwebflux.repository.CustomerRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

interface CustomerService {

    fun getCustomers(): List<Customer>
    fun getCustomer(id: Int): Mono<Customer?>
    fun saveCustomer(customerMono: Customer): Mono<Customer>

}

@Service
internal class CustomerServiceImpl(
        private val customerRepository: CustomerRepository
): CustomerService {
    override fun getCustomers(): List<Customer> {
        return customerRepository.findAll()
    }

    override fun getCustomer(id: Int): Mono<Customer?> {
        return customerRepository.findById(id)
                .map { Mono.just(it)}
                .orElse(Mono.empty<Customer>())
    }

    override fun saveCustomer(customer: Customer): Mono<Customer> {
        return customer.toMono()
                .map {
                    customerRepository.save(it)
                }
    }
}