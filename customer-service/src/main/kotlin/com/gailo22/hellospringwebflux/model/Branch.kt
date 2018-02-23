package com.gailo22.hellospringwebflux.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "BRANCH")
data class Branch(

    @Id
    val branchId: String,

    @Column(name = "BRANCH_NAME", nullable = false)
    val name: String,

    @OneToMany(
        mappedBy = "branch",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    val employees: List<Employee> = listOf()
)

data class BranchDto(
    val branchId: String,
    val name: String,
    val employees: List<EmployeeDto> = listOf()
)

fun Branch.toDto() =
    BranchDto(branchId, name, employees.map { it.toDto() })

fun BranchDto.toDomain() =
    Branch(branchId, name)
