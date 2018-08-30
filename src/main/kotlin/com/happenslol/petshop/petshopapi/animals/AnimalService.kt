package com.happenslol.petshop.petshopapi.animals

import com.happenslol.petshop.petshopapi.employees.EmployeeRepository
import com.happenslol.petshop.petshopapi.orNull
import org.springframework.stereotype.Service

@Service
class AnimalService(
    val animalRepository: AnimalRepository,
    val employeeRepository: EmployeeRepository
) {
    fun findById(id: String): Animal? = animalRepository.findById(id).orNull()
    fun all(): List<Animal> = animalRepository.findAll()
    fun save(animal: Animal): Animal = animalRepository.save(animal)
    fun delete(animal: Animal) = animalRepository.delete(animal)

    fun animalSpeciesCount(): Map<String, Int> =
        animalRepository.findAll()
            .groupBy { it.species }
            .mapValues { it.value.count() }

    fun animalsForSale(): List<Animal> {
        val employees = employeeRepository.findAll()
        val employeePetNames = employees.mapNotNull { it.petName }

        val animals = animalRepository.findAll()
        val notEmployeePets = animals.filter { it.name !in employeePetNames }

        val animalsWithPrice = animals.filter { it.price != null }

        return (animalsWithPrice + notEmployeePets).distinctBy { it.id }
    }
}
