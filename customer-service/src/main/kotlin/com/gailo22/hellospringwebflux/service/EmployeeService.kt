package com.gailo22.hellospringwebflux.service

import com.gailo22.hellospringwebflux.exception.NotFoundException
import com.gailo22.hellospringwebflux.model.BranchDto
import com.gailo22.hellospringwebflux.model.EmployeeDto
import com.gailo22.hellospringwebflux.model.toDomain
import com.gailo22.hellospringwebflux.model.toDto
import com.gailo22.hellospringwebflux.repository.BranchRepository
import com.gailo22.hellospringwebflux.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val branchRepository: BranchRepository
) {

    fun get(id: String): EmployeeDto {
        val employee = employeeRepository.findById(id).orElseThrow { NotFoundException() }

        return employee.toDto()
    }

    fun save(employeeDto: EmployeeDto): EmployeeDto {
        val branch = branchRepository.findById(employeeDto.branchId).orElse(null)
        val employee = employeeRepository.save(employeeDto.toDomain(branch))

        return employee.toDto()
    }

    fun update(employeeDto: EmployeeDto): EmployeeDto {
        val existingEmployee = employeeRepository.findById(employeeDto.employeeId).orElseThrow { NotFoundException() }
        val existingBranch = branchRepository.findById(employeeDto.branchId).orElseThrow { NotFoundException() }
        val toUpdate = existingEmployee.copy(name = employeeDto.name, branch = existingBranch)
        val employee = employeeRepository.save(toUpdate)

        return employee.toDto()
    }

    fun update2(employeeDto: EmployeeDto): EmployeeDto {
        val existingBranch = branchRepository.findById(employeeDto.branchId).orElseThrow { NotFoundException() }
        val employee = employeeRepository.save(employeeDto.toDomain(existingBranch))

        return employee.toDto()
    }
}