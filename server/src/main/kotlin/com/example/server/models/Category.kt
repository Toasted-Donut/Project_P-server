package com.example.server.models

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
public data class Category (
    @Id
    private val id: Int,
    private val name: String

)