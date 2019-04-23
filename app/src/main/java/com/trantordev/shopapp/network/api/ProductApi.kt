package com.trantordev.shopapp.network.api

import com.trantordev.shopapp.network.model.ProductPage
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    @GET("products/home")
    fun getProducts(
            @Query("page") page: Int
    ): Single<ProductPage>

}