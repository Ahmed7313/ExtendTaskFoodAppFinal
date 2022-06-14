package com.example.extendtaskfoodapp.UIScreens.CategoryScreen

import com.example.domain.model.CategoryResponse


data class CategoryState(
    var isLoading:Boolean=false,
    var data: CategoryResponse? =null,
    var error:String=""
)