package com.example.extendtaskfoodapp.datasource.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.extendtaskfoodapp.datasource.usecase.IGetCategoriesUseCase
import com.example.extendtaskfoodapp.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    useCase: IGetCategoriesUseCase
) : ViewModel() {

    private val _listOfCategories : MutableState<List<Category>> = mutableStateOf(emptyList())
    val listOfCategories : State<List<Category>> = _listOfCategories
    init {
        viewModelScope.launch {
           var categoryList = useCase()
            _listOfCategories.value = categoryList.categories
        }
    }
}