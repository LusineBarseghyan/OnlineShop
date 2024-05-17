package com.example.myapplication.module.net.dataSource

import com.example.myapplication.module.data.CartDto
import com.example.myapplication.module.data.CartsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CartDataSource {
    @GET("carts")
    suspend fun getCarts(): Response<CartsDto>

    @GET("carts/{id}")
    suspend fun getCartById(@Path("id") id: Int): Response<CartDto>
}