package com.androiddevelopertechnicalchallenge.data.remotedatasources

import com.androiddevelopertechnicalchallenge.data.services.ProductApi
import com.androiddevelopertechnicalchallenge.model.ProductDTO
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val productApi: ProductApi
) {

    suspend fun getProductList(queries: Map<String, String>): Response<ProductDTO> {
        return productApi.getProductList(queries)
    }
}