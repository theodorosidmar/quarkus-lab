package com.github.theodorosidmar.quarkuslab.domain

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class FruitRepository {
	private val fruits: MutableSet<Fruit> = mutableSetOf()

	fun findFruits(): List<Fruit>
		= fruits.toList()

	fun addFruit(fruit: Fruit) {
		fruits.add(fruit)
	}
}
