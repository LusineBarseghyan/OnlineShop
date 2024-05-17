package com.example.myapplication.module.net.repository

import com.example.myapplication.module.data.CartDto
import com.example.myapplication.module.data.CartsDto
import com.example.myapplication.module.net.dataSource.CartDataSource

interface Repository {

    suspend fun getCarts(resultCallback: ApiResultCallback<CartsDto?>, isShowLoader: Boolean)

    suspend fun getCartById(resultCallback: ApiResultCallback<CartDto?>, isShowLoader: Boolean, id: Int)
}

class RepositoryImplementation(private val dataSource: CartDataSource) : Repository {
    override suspend fun getCarts(resultCallback: ApiResultCallback<CartsDto?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getCarts()
        }
    }

    override suspend fun getCartById(resultCallback: ApiResultCallback<CartDto?>, isShowLoader: Boolean, id: Int) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getCartById(id)
        }
    }
}