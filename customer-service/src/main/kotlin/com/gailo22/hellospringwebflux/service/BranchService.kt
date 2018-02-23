package com.gailo22.hellospringwebflux.service

import com.gailo22.hellospringwebflux.exception.NotFoundException
import com.gailo22.hellospringwebflux.model.BranchDto
import com.gailo22.hellospringwebflux.model.toDomain
import com.gailo22.hellospringwebflux.model.toDto
import com.gailo22.hellospringwebflux.repository.BranchRepository
import org.springframework.stereotype.Service

@Service
class BranchService(
    private val branchRepository: BranchRepository
) {

    fun get(id: String): BranchDto {
        val branch = branchRepository.findById(id).orElseThrow { NotFoundException() }

        return branch.toDto()
    }

    fun save(branchDto: BranchDto): BranchDto {
        val branch = branchRepository.save(branchDto.toDomain())

        return branch.toDto()
    }
}