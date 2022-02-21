package com.example.presentation.ui

import androidx.lifecycle.ViewModel
import com.example.presentation.ui.network.ApiResponse
import com.example.presentation.ui.network.MyRetrofit
import kotlinx.coroutines.flow.flow


class ArticleListViewModel : ViewModel() {

    suspend fun getArticles(section: String, period: String, apiKey: String) = flow {
        val response = MyRetrofit.getInstance().lisArticles(section, period, apiKey)
        if (response.isSuccessful)
            emit(ApiResponse.ApiSuccess(response.body()))
        else
            emit(ApiResponse.ApiFailure(response.message(), response.code(), null))
    }
}