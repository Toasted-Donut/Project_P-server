package com.example.server.models

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Category (
    @Id
    val id: Int,
    val name: String
)