package com.gailo22.hellospringwebflux.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "EMPLOYEE")
data class Employee(

    @Id
    val employeeId: String,

    @Column(name = "NAME", nullable = false)
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRANCH_ID")
    val branch: Branch
)

data class EmployeeDto(
    val employeeId: String,
    val name: String,
    val branchId: String
)

fun Employee.toDto() =
    EmployeeDto(employeeId, name, branch.branchId)

fun EmployeeDto.toDomain(branch: Branch) =
    Employee(employeeId, name, branch)

