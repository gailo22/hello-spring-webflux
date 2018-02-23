package com.gailo22.hellospringwebflux.repository

import com.gailo22.hellospringwebflux.model.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentRepository: JpaRepository<Department, Long> {
}