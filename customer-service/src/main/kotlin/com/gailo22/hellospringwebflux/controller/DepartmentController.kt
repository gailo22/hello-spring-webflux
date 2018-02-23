package com.gailo22.hellospringwebflux.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.gailo22.hellospringwebflux.model.Department
import com.gailo22.hellospringwebflux.model.PersonSource
import com.gailo22.hellospringwebflux.repository.DepartmentRepository
import org.springframework.web.bind.annotation.*
import ma.glasnost.orika.MapperFacade
import org.springframework.beans.factory.annotation.Autowired



@RestController
class DepartmentController(
    private val departmentRepository: DepartmentRepository,
    private val orikaMapperFacade: MapperFacade
) {

    @PostMapping("/departments")
    fun add(@RequestBody department: Department) {
        val mapper = ObjectMapper()
        val readTree = mapper.readValue(department.personJson, PersonSource::class.java)
        val jsonString = mapper.writeValueAsString(readTree.copy(name = "jon1"))
        departmentRepository.save(department.copy(personJson = jsonString))
    }

    @GetMapping("/departments/{id}")
    fun get(@PathVariable id: Long): Department {
        return departmentRepository.getOne(id)
    }

}