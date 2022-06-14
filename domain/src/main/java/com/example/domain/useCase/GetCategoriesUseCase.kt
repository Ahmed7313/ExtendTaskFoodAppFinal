package com.example.domain.useCase

import com.example.domain.model.CategoryResponse
import com.example.domain.reprository.ICategoryRepository
import com.gaur.common.ViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

interface IGetCategoriesUseCase{

    operator fun invoke() : Flow<ViewState<CategoryResponse>>
}
class GetCategoriesUseCase  @Inject constructor(
    val repo : ICategoryRepository
) : IGetCategoriesUseCase{
    override fun invoke(): Flow<ViewState<CategoryResponse>> = flow {
        try {
            val response = repo.getAllCategories()
            emit(ViewState.Success(data = response))

        }catch (e:Exception){
            emit(ViewState.Error("error occurred"))
        }
    }


}