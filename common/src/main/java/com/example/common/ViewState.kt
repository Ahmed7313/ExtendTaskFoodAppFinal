package com.gaur.common

sealed  class ViewState<T>(val data:T?=null, val message:String?=null){

    class  Success<T>(data:T?): ViewState<T>(data = data)

    class Loading<T>(message: String?) : ViewState<T>()

    class Error<T>(message:String?) : ViewState<T>(message= message)
}
