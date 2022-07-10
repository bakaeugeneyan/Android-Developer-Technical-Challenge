package com.androiddevelopertechnicalchallenge.data.localdatasources

import com.androiddevelopertechnicalchallenge.data.daos.ProductDao
import com.androiddevelopertechnicalchallenge.data.entities.ProductEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val productDao: ProductDao
) {
    suspend fun insertProducts(productEntity: ProductEntity) {
        productDao.insertProduct(productEntity)
    }
}