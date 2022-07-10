package com.androiddevelopertechnicalchallenge.data.localdatasources

import com.androiddevelopertechnicalchallenge.data.daos.ProductDao
import com.androiddevelopertechnicalchallenge.data.entities.ProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val productDao: ProductDao
) {

    fun readDatabase(): Flow<List<ProductEntity>> {
        return productDao.readProducts()
    }

    suspend fun insertProducts(productEntity: ProductEntity) {
        productDao.insertProduct(productEntity)
    }
}