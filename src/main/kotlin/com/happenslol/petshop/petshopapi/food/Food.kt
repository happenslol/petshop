package com.happenslol.petshop.petshopapi.food

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.repository.MongoRepository

data class FoodStock(
    @Id
    val name: String,
    val count: Int
)

interface FoodStockRepository : MongoRepository<FoodStock, String>
