package com.github.theodorosidmar.quarkuslab.domain

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class FruitService(
	@Inject private val repository: FruitRepository
) {
	fun getFruits(): List<Fruit> =
		repository.findFruits()

	fun addFruit(fruit: Fruit) {
		repository.addFruit(fruit = fruit)
	}
}
