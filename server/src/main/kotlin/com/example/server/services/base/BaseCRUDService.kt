package com.example.server.services.base

import java.io.Serializable

interface BaseCRUDService <T, ID : Serializable>{
    fun save(item:T):T
    fun findById(id:ID):T?
    fun updateById(id:ID, item: T):T?
    fun saveAll(items: List<T>):List<T>
    fun findAll():List<T>
    fun deleteById(id:ID)
}