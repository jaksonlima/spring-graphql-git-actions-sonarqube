package com.spring.graphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux

@SpringBootApplication
class GraphqlApplication

fun main(args: Array<String>) {
    runApplication<GraphqlApplication>(*args)
}

@Controller
class GraphQLController {

    private val db = listOf(Customer(1, "A"), Customer(2, "B"))

    @QueryMapping
    fun customersByName(@Argument name: String) = this.db.filter { it.name == name }

    @SchemaMapping(typeName = "Query", field = "customers")
    fun customers() = Flux.just(Customer(1, "A"), Customer(2, "B"))

}

data class Customer(val id: Int, val name: String)