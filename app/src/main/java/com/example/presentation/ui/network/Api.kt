package com.example.presentation.ui.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("svc/mostpopular/v2/{section}/{period}")
    suspend fun lisArticles(
        @Path("section") section: String,
        @Path("period") period: String,
        @Query("api-key") apiKey: String
    ): Response<ArticlePopularList>
}