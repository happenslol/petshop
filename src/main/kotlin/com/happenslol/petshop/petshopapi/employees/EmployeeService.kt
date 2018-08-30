package com.happenslol.petshop.petshopapi.employees

import com.happenslol.petshop.petshopapi.animals.Animal
import com.happenslol.petshop.petshopapi.animals.AnimalRepository
import com.happenslol.petshop.petshopapi.animals.AnimalSpeciesRepository
import com.happenslol.petshop.petshopapi.orNull
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    val employeeRepository: EmployeeRepository,
    val animalRepository: AnimalRepository,
    val speciesRepository: AnimalSpeciesRepository
) {
    fun all(): List<Employee> = employeeRepository.findAll()

    fun employeePets(): List<Animal> =
        employeeRepository.findAll()
            .mapNotNull { it.petName }
            .mapNotNull { animalRepository.findByName(it) }

    fun addPetToEmployee(animal: Animal, employee: Employee): Employee {
        val toSave = employee.copy(
            petName = animal.name
        )

        return employeeRepository.save(toSave)
    }

    fun foodAmountForEmployeePets(): Map<String, Int> {
        val employees = employeeRepository.findAll()

        val employeePetSpeciesCount = employees
            .mapNotNull { it.petName }
            .mapNotNull { animalRepository.findByName(it) }
            .groupBy { it.species }
            .mapValues { it.value.count() }
            .toMap()

        val foodForSpecies = employeePetSpeciesCount
            .mapNotNull { (speciesName, count) ->
                val species = speciesRepository.findById(speciesName).orNull()
                    ?: return@mapNotNull null

                species.food to count
            }
            .toMap()

        return foodForSpecies
    }

    fun foodForEmployee(id: String): String =
        employeeRepository.findById(id).orNull()
            ?.petName
            ?.let { animalRepository.findByName(it) }
            ?.let { speciesRepository.findById(it.species).orNull() }
            ?.food ?: "Employee has no pet!"

    fun enoughFoodForEmployees(): Boolean {
        // NOTE: This function should return whether or not there is enough food
        // in stock to feed all the employees pets once.
        TODO("Not implemented")
    }
}
