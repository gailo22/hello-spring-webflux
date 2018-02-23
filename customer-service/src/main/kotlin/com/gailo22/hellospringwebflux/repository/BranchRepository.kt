package com.gailo22.hellospringwebflux.repository

import com.gailo22.hellospringwebflux.model.Branch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BranchRepository: JpaRepository<Branch, String>