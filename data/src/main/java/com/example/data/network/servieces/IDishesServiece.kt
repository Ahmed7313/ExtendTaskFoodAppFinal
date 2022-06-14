package com.example.data.network.servieces

import com.example.data.network.model.DishResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface IDishService {

    @GET("filter.php")
    suspend fun getAllMeals(@Query("c")  dishCategory: String?): DishResponseDTO
}