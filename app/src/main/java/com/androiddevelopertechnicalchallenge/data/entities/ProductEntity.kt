package com.androiddevelopertechnicalchallenge.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.androiddevelopertechnicalchallenge.model.ProductDTO
import com.androiddevelopertechnicalchallenge.utils.Constants.PRODUCT_TABLE

@Entity(tableName = PRODUCT_TABLE)
class ProductEntity(
    var product: ProductDTO
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}