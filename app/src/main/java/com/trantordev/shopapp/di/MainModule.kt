package com.trantordev.shopapp.di

import com.trantordev.shopapp.network.ServiceApiInitializer
import com.trantordev.shopapp.util.Constants
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val RETROFIT = "retrofit"
const val OKHTTP = "okhttp"

val mainModule = module {
//  single { MainActivity(get()) }

  single { ServiceApiInitializer() }

    single(RETROFIT) {

        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http:// trocar aqui")
                .client(get(OKHTTP))
                .build()
    }

    single(OKHTTP) {

        OkHttpClient
                .Builder()
                .connectTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .build()
    }
}