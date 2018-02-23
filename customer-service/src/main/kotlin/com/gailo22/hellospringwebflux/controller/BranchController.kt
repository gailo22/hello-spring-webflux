package com.gailo22.hellospringwebflux.controller

import com.gailo22.hellospringwebflux.model.BranchDto
import com.gailo22.hellospringwebflux.service.BranchService
import org.springframework.web.bind.annotation.*

@RestController
class BranchController(
    private val branchService: BranchService
) {

    @GetMapping("/branches/{id}")
    fun get(@PathVariable id: String): BranchDto {
        return branchService.get(id)
    }

    @PostMapping("/branches")
    fun create(@RequestBody data: CreateBranchRequest): BranchDto {
        val branch = BranchDto(data.branchId, data.name)
        return branchService.save(branch)
    }
}

data class CreateBranchRequest(
    val branchId: String,
    val name: String
)