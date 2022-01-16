package com.github.theodorosidmar.quarkuslab.rest

import com.github.theodorosidmar.quarkuslab.domain.Fruit
import com.github.theodorosidmar.quarkuslab.domain.FruitService
import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.POST
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.Response.Status

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class FruitResource(
	@Inject private val service: FruitService
) {
	@GET
	fun get(): List<Fruit> =
		service.getFruits()

	@POST
	fun post(@Valid fruit: Fruit): Response {
		service.addFruit(fruit = fruit)
		return Response.status(Status.CREATED).build()
	}
}
