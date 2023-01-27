package com.example.testtaskfornwcode.data.network

import com.example.testtaskfornwcode.data.models.ApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/?key=33106230-b104905cd7ff74ed17e2229af")
    suspend fun getImages(@Query("category") category: String): Response<ApiModel>
}