package com.example.server.models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Product(
    @Id
    val name: String,
    @ManyToOne
    var category: Category
)
