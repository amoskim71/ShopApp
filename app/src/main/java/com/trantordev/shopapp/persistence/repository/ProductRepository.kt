package com.trantordev.shopapp.persistence.repository

import com.trantordev.shopapp.network.api.ProductBackendApiDecorator
import com.trantordev.shopapp.network.model.ProductPage
import com.trantordev.shopapp.network.model.Products
import io.reactivex.Observable
import io.reactivex.annotations.NonNull
import timber.log.Timber
import java.util.Locale.filter
import java.util.concurrent.TimeUnit

class ProductRepository(val productApi: ProductBackendApiDecorator) {

    fun searchFor(page: Int): Observable<ProductPage> {

        if (page <= 0) {
            return Observable.error<ProductPage>(IllegalArgumentException("Invalid page number"))
        }

        Timber.d("INJECTION: ProductRepository")
        return productApi.getProducts(page)
    }

}