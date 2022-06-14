package com.example.domain.reprository

import com.example.domain.model.CategoryResponse

interface ICategoryRepository {
    suspend fun getAllCategories(): CategoryResponse
}