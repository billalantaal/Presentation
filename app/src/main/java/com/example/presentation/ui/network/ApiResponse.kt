package com.example.presentation.ui.network

sealed class ApiResponse<out T> {

    data class ApiSuccess<T>(val data: T) : ApiResponse<T>()
    data class ApiFailure<T>(val message: String, val code: Int, val e: Exception?) :
        ApiResponse<T>()
}
