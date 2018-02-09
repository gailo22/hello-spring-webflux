package com.gailo22.hellospringwebflux.repository

import com.gailo22.hellospringwebflux.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Int>