package com.androiddevelopertechnicalchallenge.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductDTO(
    @SerializedName("products")
    val products: List<Product> = listOf(),
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("skip")
    val skip: Int = 0,
    @SerializedName("limit")
    val limit: Int = 0
) : Parcelable {
    @Parcelize
    data class Product(
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("title")
        val title: String = "",
        @SerializedName("description")
        val description: String = "",
        @SerializedName("price")
        val price: Int = 0,
        @SerializedName("discountPercentage")
        val discountPercentage: Double = 0.0,
        @SerializedName("rating")
        val rating: Double = 0.0,
        @SerializedName("stock")
        val stock: Int = 0,
        @SerializedName("brand")
        val brand: String = "",
        @SerializedName("category")
        val category: String = "",
        @SerializedName("thumbnail")
        val thumbnail: String = "",
        @SerializedName("images")
        val images: List<String> = listOf()
    ) : Parcelable
}