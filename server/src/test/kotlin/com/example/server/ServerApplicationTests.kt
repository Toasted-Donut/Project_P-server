package com.example.server

import com.example.server.controls.ProductController
import com.example.server.models.Category
import com.example.server.models.Product
import com.example.server.requests.AddRequest
import com.example.server.services.CategoryService
import com.example.server.services.ProductService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.*

@ExtendWith(MockitoExtension::class)
class ProductControllerTest {

    @Mock
    lateinit var productService: ProductService

    @Mock
    lateinit var categoryService: CategoryService

    @InjectMocks
    lateinit var productController: ProductController

    @Test
    fun `getProductById should return product`() {
        val product = Product("Test Product", Category(1,"Test Category"))
        lenient().`when`(productService.findById("Test Product")).thenReturn(product)

        val response: ResponseEntity<Optional<Product>> = productController.getProductById("Test Product")

        assertEquals(HttpStatus.OK, response.statusCode)
        assertTrue(response.body!!.isPresent)
        assertEquals("Test Product", response.body!!.get().name)
    }

    @Test
    fun `getProducts should return list of products`() {
        val products = listOf(Product("Test Product 1", Category(1,"Test Category")), Product("Test Product 2", Category(1,"Test Category")))
        lenient().`when`(productService.findAll()).thenReturn(products)

        val response: ResponseEntity<Optional<List<Product>>> = productController.getProducts()

        assertEquals(HttpStatus.OK, response.statusCode)
        assertTrue(response.body!!.isPresent)
        assertEquals(2, response.body!!.get().size)
    }

    @Test
    fun `addProducts should add product`() {
        val category = Category(1, "TestCategory")
        val product = Product("New Product", category)
        val request = AddRequest(1, "New Product")

        lenient().`when`(categoryService.findById(1)).thenReturn(category)
        lenient().`when`(productService.save(product)).thenReturn(product)

        val response: ResponseEntity<Product> = productController.addProducts(request)

        assertEquals(HttpStatus.ACCEPTED, response.statusCode)
        assertEquals("New Product", response.body!!.name)
    }

    @Test
    fun `update should update product category`() {
        val category = Category(103, "UpdatedCategory")
        val product = Product("1", Category(1, "TestCategory"))

        lenient().`when`(categoryService.findById(103)).thenReturn(category)
        lenient().`when`(productService.findById("1")).thenReturn(product)
        lenient().`when`(productService.save(Product("1", category))).thenReturn(product)

        val response: ResponseEntity<Product> = productController.update("1", 103)

        assertEquals(HttpStatus.ACCEPTED, response.statusCode)
        assertEquals("UpdatedCategory", response.body!!.category.name)
    }

    @Test
    fun `delete should remove product`() {
        doNothing().`when`(productService).deleteById("1")

        val response: ResponseEntity<Product> = productController.delete("1")

        assertEquals(HttpStatus.OK, response.statusCode)
    }
}

