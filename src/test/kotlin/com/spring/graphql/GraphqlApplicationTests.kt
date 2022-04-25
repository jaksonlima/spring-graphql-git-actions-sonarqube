package com.spring.graphql

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GraphqlApplicationTests {

    @Test
    fun graphQLControllerTestCustomersByName() {
        val graphQLController = GraphQLController()

        val customersByName = graphQLController.customersByName("A")

        Assertions.assertEquals(customersByName[0].name, "A")
        Assertions.assertEquals(customersByName[0].id, 1)
    }

    @Test
    fun graphQLControllerTestCustomers() {
        val graphQLController = GraphQLController()

        val customersByName = graphQLController.customers()

        Assertions.assertNotNull(customersByName)
    }

}
