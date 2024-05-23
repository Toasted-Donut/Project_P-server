package com.example.server.repo

import com.example.server.models.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product,String> {
}