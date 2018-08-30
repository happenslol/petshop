package com.happenslol.petshop.petshopapi.data

import com.happenslol.petshop.petshopapi.animals.Animal
import com.happenslol.petshop.petshopapi.animals.AnimalRepository
import com.happenslol.petshop.petshopapi.animals.AnimalSpeciesRepository
import com.happenslol.petshop.petshopapi.animals.Species
import com.happenslol.petshop.petshopapi.employees.Employee
import com.happenslol.petshop.petshopapi.employees.EmployeeRepository
import com.happenslol.petshop.petshopapi.food.FoodStock
import com.happenslol.petshop.petshopapi.food.FoodStockRepository
import org.springframework.stereotype.Service

@Service
class TestDataService(
    val foodStockRepository: FoodStockRepository,
    val animalRepository: AnimalRepository,
    val animalSpeciesRepository: AnimalSpeciesRepository,
    val employeeRepository: EmployeeRepository
) {
    fun deleteAll() {
        foodStockRepository.deleteAll()
        animalRepository.deleteAll()
        animalSpeciesRepository.deleteAll()
        employeeRepository.deleteAll()
    }

    fun loadTestData() {
        foodStockRepository.saveAll(foodStockData())
        animalRepository.saveAll(animalData())
        animalSpeciesRepository.saveAll(animalSpeciesData())
        employeeRepository.saveAll(employeeData())
    }

    fun foodStockData(): List<FoodStock> = listOf()
    fun animalData(): List<Animal> = listOf()
    fun animalSpeciesData(): List<Species> = listOf()
    fun employeeData(): List<Employee> = listOf()
}
