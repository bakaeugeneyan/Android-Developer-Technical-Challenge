package com.androiddevelopertechnicalchallenge.data.services

import com.androiddevelopertechnicalchallenge.model.ProductDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ProductApi {

    @GET("products")
    suspend fun getProductList(
        @QueryMap queries: Map<String, String>
    ): Response<ProductDTO>
}