package com.happenslol.petshop.petshopapi.employees

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

@Document
data class Employee(

    @Id
    val id: String = UUID.randomUUID().toString(),

    val name: Name,
    val petName: String? = null
)

data class Name(
    val firstName: String,
    val lastName: String
)

interface EmployeeRepository : MongoRepository<Employee, String>
