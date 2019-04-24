package com.trantordev.shopapp.network.api

import com.trantordev.shopapp.network.model.ProductPage
import io.reactivex.Observable
import org.koin.core.context.GlobalContext.get
import org.koin.core.qualifier.named
import timber.log.Timber

class ProductBackendApiDecorator(val productService: ProductBackendApi) {

    fun getProducts(pagination: Int): Observable<ProductPage> {
        Timber.d("INJECTION: ProductDecoratorAPI")
        return productService.getProducts(pagination)
    }

}