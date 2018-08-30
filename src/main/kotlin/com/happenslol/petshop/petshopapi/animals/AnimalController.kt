package com.happenslol.petshop.petshopapi.animals

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("animals")
class AnimalController(
    val animalService: AnimalService
) {
    @GetMapping
    fun all(): List<Animal> = animalService.all()

    @GetMapping("/{id}")
    fun get(
        @PathVariable("id")
        id: String
    ): Animal? = animalService.findById(id)

    @GetMapping("/{id}/price")
    fun priceForId(
        @PathVariable("id")
        id: String
    ): Int? = animalService.findById(id)?.price

    @PostMapping
    fun create(
        @RequestBody
        animal: Animal
    ): Animal = animalService.save(animal)

    @PutMapping("/{id}")
    fun update(
        @PathVariable("id")
        id: String,

        @RequestBody
        animal: Animal
    ): Animal {
        animalService.findById(id) ?: error("animal not found")
        return animalService.save(animal)
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable("id")
        id: String
    ): ResponseEntity<Any> {
        val toDelete = animalService.findById(id) ?: error("animal not found")
        animalService.delete(toDelete)

        return ResponseEntity.noContent().build()
    }
}
