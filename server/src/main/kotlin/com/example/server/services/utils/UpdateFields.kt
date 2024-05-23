package com.example.server.services.utils

class UpdateFields {
    fun updateField(newObj: Any, oldObj: Any){
        newObj::class.java.declaredFields.filter { field ->
            field.isAccessible = true
            try {
                field.get(newObj) != null
            } catch (e: IllegalAccessException) {
                throw RuntimeException(e)
            }
        }.forEach { field ->
            field.isAccessible = true
            try {
                field.set(oldObj, field.get(newObj))
            } catch (e: IllegalAccessException) {
                throw RuntimeException(e)
            }
        }
    }
}