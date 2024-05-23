package com.example.server.services.impl

import com.example.server.models.Category
import com.example.server.repo.CategoryRepository
import com.example.server.services.CategoryService
import com.example.server.services.base.BaseCRUDService
import com.example.server.services.utils.UpdateFields
import jakarta.transaction.Transactional

import org.springframework.stereotype.Service
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.UpperIfFlexible

@Service
@Transactional
class CategoryServiceImpl(val categoryRepository: CategoryRepository) : CategoryService {

    override fun save(item: Category): Category {
        return categoryRepository.save(item)
    }

    override fun findById(id: Int): Category {
        return  categoryRepository.findById(id).orElse(null);
    }

    override fun updateById(id: Int, item: Category): Category? {
        val oldItem = findById(id) ?: return null
        UpdateFields().updateField(item,oldItem)
        return save(oldItem)
    }

    override fun saveAll(items: List<Category>): List<Category> {
        return categoryRepository.saveAll(items)
    }

    override fun findAll(): List<Category> {
        return categoryRepository.findAll()
    }

    override fun deleteById(id: Int) {
        categoryRepository.deleteById(id)
    }

}