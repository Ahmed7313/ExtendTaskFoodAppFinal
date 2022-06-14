package com.example.extendtaskfoodapp.UIScreens.CategoryScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.useCase.IGetCategoriesUseCase
import com.example.extendtaskfoodapp.model.Category
import com.gaur.common.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    useCase: IGetCategoriesUseCase
) : ViewModel() {


    private val _categories = mutableStateOf(CategoryState())
    val categories: State<CategoryState> = _categories


        init {
            useCase().onEach {
                when (it) {
                    is ViewState.Loading -> {
                        _categories.value = CategoryState(isLoading = true)
                    }
                    is ViewState.Success -> {
                        _categories.value = CategoryState(data = it.data)
                    }
                    is ViewState.Error -> {
                        _categories.value = CategoryState(error = it.message.toString())
                    }
                }
            }.launchIn(viewModelScope)
    }
}