package com.example.data.network.servieces


import com.example.data.network.model.CategoryResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ICategoryService {
    @GET("categories.php")
    suspend fun getAllCategories(): Response<CategoryResponseDTO>}