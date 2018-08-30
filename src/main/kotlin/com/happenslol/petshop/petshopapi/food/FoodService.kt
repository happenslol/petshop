package com.happenslol.petshop.petshopapi.food

import org.springframework.stereotype.Service

@Service
class FoodService(
    foodStockRepository: FoodStockRepository
) {
    fun all(): List<FoodStock> {
        TODO("Not implemented")
    }

    fun foodForAnimalInStock(): Boolean {
        TODO("Not implemented")
    }

    fun enoughFoodForEmployeeAnimals(): Boolean {
        TODO("Not implemented")
    }

    fun addFoodStock(stock: FoodStock): FoodStock {
        TODO("Not implemented")
    }

    fun updateFoodStock(stock: FoodStock, newCount: Int): FoodStock {
        TODO("Not implemented")
    }
}
