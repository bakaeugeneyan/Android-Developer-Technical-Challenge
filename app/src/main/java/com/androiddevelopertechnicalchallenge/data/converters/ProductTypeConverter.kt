package com.androiddevelopertechnicalchallenge.data.converters

import androidx.room.TypeConverter
import com.androiddevelopertechnicalchallenge.model.ProductDTO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun productToString(product: ProductDTO): String {
        return gson.toJson(product)
    }

    @TypeConverter
    fun stringToProducts(data: String) : ProductDTO {
        val listType = object : TypeToken<ProductDTO>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun productListToString(productList: ProductDTO.Product): String {
        return gson.toJson(productList)
    }

    @TypeConverter
    fun stringToProductList(data: String): ProductDTO.Product {
        val listType = object : TypeToken<ProductDTO.Product>() {}.type
        return gson.fromJson(data, listType)
    }
}