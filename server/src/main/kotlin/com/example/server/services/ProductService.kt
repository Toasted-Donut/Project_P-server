package com.example.server.services

import com.example.server.models.Product
import com.example.server.services.base.BaseCRUDService

interface ProductService : BaseCRUDService<Product, String>{
}