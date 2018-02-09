package com.gailo22.hellospringwebflux.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "CUSTOMER")
data class Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int,
        val name: String,
        val email: String
)

data class CustomerDto(
        val id: Int,
        val name: String,
        val email: String
)

fun CustomerDto.toObject() = Customer(id, name, email)
fun Customer.toDto() = CustomerDto(id, name, email)