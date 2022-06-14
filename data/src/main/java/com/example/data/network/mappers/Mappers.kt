package com.example.data.network.mappers

import com.example.data.network.model.CategoryDTO
import com.example.data.network.model.CategoryResponseDTO
import com.example.domain.model.Category
import com.example.domain.model.CategoryResponse
import java.util.*

fun List<CategoryDTO>.toDomain() : List<Category>{
    return map {
        Category(
            strCategory = it.strCategory,
            idCategory = it.idCategory,
            strCategoryDescription = it.strCategoryDescription,
            strCategoryThumb = it.strCategoryThumb
        )
    }
}

fun CategoryResponseDTO.toDomain() : CategoryResponse{
    return CategoryResponse(
        categories = categories.toDomain()
    )
}