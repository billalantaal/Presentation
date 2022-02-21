package com.example.presentation.ui.network

import com.example.presentation.constants.Constant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {
    companion object {
        private lateinit var instance: Retrofit
        fun getInstance(): Api {
            if (!this::instance.isInitialized) {
                instance = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            }
            return getApi(instance)
        }

        private fun getApi(retrofit: Retrofit) = retrofit.create(Api::class.java)
    }
}