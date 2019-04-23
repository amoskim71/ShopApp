package com.trantordev.shopapp.network.api

import com.trantordev.shopapp.network.model.ProductPage
import io.reactivex.Observable
import timber.log.Timber

class ProductBackendApiDecorator(val api: ProductBackendApi) {

    fun getProducts(pagination: Int): Observable<ProductPage> {
        Timber.d("INJECTION: ProductDecoratorAPI")
        return api.getProducts(pagination)
    }

}