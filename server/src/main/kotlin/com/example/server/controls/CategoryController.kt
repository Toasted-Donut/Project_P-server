package com.example.server.controls

import com.example.server.models.Category
import com.example.server.services.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import java.util.Optional


@Component
@RestController
@CrossOrigin
@RequestMapping("/category")
class CategoryController(val categoryService: CategoryService) {

    @GetMapping(params = ["id"],produces = ["application/json"])
    fun getCategory(@RequestParam id: Int): ResponseEntity<Optional<Category>>{
        val category: Optional<Category> = Optional.ofNullable(categoryService.findById(id))
        return ResponseEntity.ok(category)
    }
    @GetMapping(produces = ["application/json"])
    fun getCategories(): ResponseEntity<Optional<List<Category>>>{
        val categories: Optional<List<Category>> = Optional.ofNullable(categoryService.findAll())
        return ResponseEntity.ok(categories)
    }

}