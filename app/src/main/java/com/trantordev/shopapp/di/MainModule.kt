package com.trantordev.shopapp.di

import com.trantordev.shopapp.feature.home.HomeInteractor
import com.trantordev.shopapp.feature.home.HomePresenter
import com.trantordev.shopapp.feature.product.list.ProductInteractor
import com.trantordev.shopapp.feature.product.list.ProductPresenter
import com.trantordev.shopapp.network.api.ProductApi
import com.trantordev.shopapp.network.api.ProductBackendApi
import com.trantordev.shopapp.network.api.ProductBackendApiDecorator
import com.trantordev.shopapp.persistence.repository.ProductRepository
import com.trantordev.shopapp.util.Constants
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val RETROFIT = "retrofit"
const val OKHTTP = "okhttp"
const val RETROFIT_PRODUCTAPI = "retrofit_product_api"
const val RETROFIT_PRODUCT_BACKEND_API = "retrofit_product_backend_api"

val mainModule = module {

    single(named(RETROFIT)) {

        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://private-anon-0c3dd64669-enjoeitest.apiary-mock.com/")
                .client(get(named(OKHTTP)))
                .build()
    }

    single(named(OKHTTP)) {
        OkHttpClient
                .Builder()
                .connectTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .build()
    }

    single<ProductApi>(named(RETROFIT_PRODUCTAPI)) {
        val retrofit: Retrofit = get(named(RETROFIT))
        retrofit.create(ProductApi::class.java)
    }

    single {
        val retrofit: Retrofit = get(named(RETROFIT))
        retrofit.create(ProductBackendApi::class.java)
    }

    single{
        ProductBackendApiDecorator(get())
    }

    single{
        ProductRepository(get())
    }

    single{
        ProductInteractor(get())
    }

    single{
        ProductPresenter(get())
    }

    single{
        HomePresenter(get())
    }

    single{
        HomeInteractor()
    }

}