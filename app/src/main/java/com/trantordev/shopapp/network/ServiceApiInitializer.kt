package com.trantordev.shopapp.network

import com.trantordev.shopapp.network.api.ProductApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ServiceApiInitializer( ): ProductApi{

private val service = Retrofit.Builder()
                .baseUrl("http://192.168.0.23:8080/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

    fun productApi(): ProductApi = service.create(ProductApi::class.java)

}

