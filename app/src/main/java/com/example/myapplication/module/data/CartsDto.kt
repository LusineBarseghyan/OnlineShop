package com.example.myapplication.module.data
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CartsDto(
    @SerializedName("carts")
    val carts: List<CartDto>
) : Serializable

data class CartDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("discountPercentage")
    val discountPercentage: Float,
    @SerializedName("thumbnail")
    val thumbnail: String
) : Serializable
