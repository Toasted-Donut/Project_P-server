package com.example.server.controls

import com.example.server.models.Product
import com.example.server.requests.AddRequest
import com.example.server.services.CategoryService
import com.example.server.services.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.Optional

@Component
@RestController
@CrossOrigin
@RequestMapping("/product")
class ProductController(val productService: ProductService, val categoryService: CategoryService) {

    @GetMapping(params = ["id"], produces = ["application/json"])
    fun getProductById(@RequestParam id: String): ResponseEntity<Optional<Product>>{
        return ResponseEntity.ok(Optional.ofNullable(productService.findById(id)))
    }
    @GetMapping(produces = ["application/json"])
    fun getProducts(): ResponseEntity<Optional<List<Product>>>{
        return ResponseEntity.ok(Optional.ofNullable(productService.findAll()))
    }
    @PostMapping(consumes = ["application/json"])
    fun addProducts(@RequestBody request: AddRequest): ResponseEntity<Product>{
        val category = categoryService.findById(request.categoryId) ?: return ResponseEntity.badRequest().build()
        val product = Product(request.name, category)
        productService.save(product)
        return ResponseEntity.accepted().body(product)
    }
    @PatchMapping
    fun update(@RequestParam id: String, @RequestParam categoryId: Int): ResponseEntity<Product>{
        val category = categoryService.findById(categoryId) ?: return ResponseEntity.badRequest().build()
        val product = productService.findById(id) ?: return ResponseEntity.badRequest().build()
        product.category = category
        productService.updateById(id, product)
        return ResponseEntity.accepted().body(product)
    }
    @DeleteMapping(params = ["id"], produces = ["application/json"])
    fun delete(@RequestParam id: String): ResponseEntity<Product>{
        productService.deleteById(id)
        return ResponseEntity.ok().build()
    }
}