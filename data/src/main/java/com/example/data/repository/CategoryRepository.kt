package com.example.data.repository

import com.example.data.network.mappers.toDomain
import com.example.data.network.servieces.ICategoryService
import com.example.domain.model.CategoryResponse
import com.example.domain.reprository.ICategoryRepository
import com.gaur.data.network.utils.SafeApiRequest
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    val service : ICategoryService
) : ICategoryRepository , SafeApiRequest(){

    override suspend fun getAllCategories(): CategoryResponse {
        val response =  safeApiRequest {service.getAllCategories()}
        return response.toDomain()
    }
}