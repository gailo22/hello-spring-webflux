package com.gailo22.hellospringwebflux.repository

import com.gailo22.hellospringwebflux.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository: JpaRepository<Employee, String>