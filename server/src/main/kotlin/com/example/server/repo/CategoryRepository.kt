package com.example.server.repo

import com.example.server.models.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category,Int>{
}