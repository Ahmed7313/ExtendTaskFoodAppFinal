package com.example.data.network.di

import com.example.data.network.servieces.ICategoryService
import com.example.data.network.servieces.IDishService
import com.example.data.repository.CategoryRepository
import com.example.domain.reprository.ICategoryRepository
import com.gaur.common.Constant.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule{

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesCategoryService(retrofit: Retrofit) : ICategoryService {
        return retrofit.create(ICategoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideMealService(retrofit: Retrofit): IDishService {
        return retrofit.create(IDishService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        @Binds
        @Singleton
        fun provideCategoryRepository(repo: CategoryRepository): ICategoryRepository


    }
}