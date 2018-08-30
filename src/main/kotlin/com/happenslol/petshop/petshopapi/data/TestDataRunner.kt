package com.happenslol.petshop.petshopapi.data

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class TestDataRunner(
    val testDataService: TestDataService
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (args.getOrNull(0) != "test-data")
            return

        testDataService.deleteAll()
        println("emptied database")

        testDataService.loadTestData()
        println("loaded test data")
    }
}
