package com.example.domain.di

import com.example.domain.reprository.ICategoryRepository
import com.example.domain.useCase.GetCategoriesUseCase
import com.example.domain.useCase.IGetCategoriesUseCase
import com.gaur.common.Constant
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule{

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {
        @Binds
        @Singleton
        fun provideGetCategoryUseCase(uc: GetCategoriesUseCase): IGetCategoriesUseCase
    }
}