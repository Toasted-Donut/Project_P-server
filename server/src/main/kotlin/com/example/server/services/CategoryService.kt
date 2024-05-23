package com.example.server.services

import com.example.server.models.Category
import com.example.server.services.base.BaseCRUDService


interface CategoryService : BaseCRUDService<Category,Int> {
}