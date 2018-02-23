package com.gailo22.hellospringwebflux.controller

import com.gailo22.hellospringwebflux.model.Branch
import com.gailo22.hellospringwebflux.model.BranchDto
import com.gailo22.hellospringwebflux.model.Employee
import com.gailo22.hellospringwebflux.model.EmployeeDto
import com.gailo22.hellospringwebflux.repository.EmployeeRepository
import com.gailo22.hellospringwebflux.service.EmployeeService
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
class EmployeeController(
    private val employeeService: EmployeeService
) {

    @GetMapping("/employees/{id}")
    fun get(@PathVariable id: String): EmployeeDto {
        return employeeService.get(id)
    }

    @PostMapping("/employees")
    fun create(@RequestBody data: CreateEmployeeRequest): EmployeeDto {
        val employeeDto = EmployeeDto(data.employeeId, data.name, data.branchId)
        return employeeService.save(employeeDto)
    }

    @PutMapping("/employees/{id}")
    fun update(@PathVariable id: String, @RequestBody data: UpdateEmployeeRequest): EmployeeDto {
        val employeeDto = EmployeeDto(id, data.name, data.branchId)
        return employeeService.update(employeeDto)
    }
}

data class CreateEmployeeRequest(
    val employeeId: String,
    val name: String,
    val branchId: String
)

data class UpdateEmployeeRequest(
    val name: String,
    val branchId: String
)