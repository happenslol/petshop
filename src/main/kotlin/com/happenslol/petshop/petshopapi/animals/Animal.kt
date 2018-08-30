package com.happenslol.petshop.petshopapi.animals

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

@Document
data class Animal(
    @Id
    val id: String = UUID.randomUUID().toString(),

    val species: String,
    val name: String,
    val age: Int,
    val price: Int? = null
)

interface AnimalRepository : MongoRepository<Animal, String> {
    fun findByName(name: String): Animal?
}

@Document
data class Species(
    @Id
    val species: String,
    val food: String
)

interface AnimalSpeciesRepository : MongoRepository<Species, String>
