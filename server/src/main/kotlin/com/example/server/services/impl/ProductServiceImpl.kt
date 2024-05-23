package com.example.server.services.impl

import com.example.server.models.Product
import com.example.server.repo.ProductRepository
import com.example.server.services.ProductService
import com.example.server.services.utils.UpdateFields
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
@Transactional
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService {
    override fun save(item: Product): Product {
        return productRepository.save(item)
    }

    override fun findById(id: String): Product? {
       return productRepository.findById(id).orElse(null)
    }

    override fun updateById(id: String, item: Product): Product? {
        val oldItem = findById(id) ?: return null
        UpdateFields().updateField(item,oldItem)
        return save(oldItem)
    }

    override fun saveAll(items: List<Product>): List<Product> {
        return productRepository.saveAll(items)
    }

    override fun findAll(): List<Product> {
        return productRepository.findAll()
    }

    override fun deleteById(id: String) {
       productRepository.deleteById(id)
    }
}