package com.trantordev.shopapp.feature.product.list

import com.trantordev.shopapp.network.model.ProductPage
import io.reactivex.Observable
import com.trantordev.shopapp.persistence.repository.ProductRepository

class ProductInteractor(val productRepository: ProductRepository) {

    fun search(page: Int): Observable<ProductViewState> {
        // Empty String, so no search
        return if (page <= 0) {
            Observable.just<ProductViewState>(ProductViewState.InitialState())
        } else productRepository.searchFor(page)
                .flatMap { productPage:ProductPage ->  Observable.just<ProductViewState>(ProductViewState.SearchResultState(page,productPage.products)) }
                .startWith(Observable.just(ProductViewState.LoadingState()))
                .onErrorReturn({ error:Throwable -> ProductViewState.ErrorState(page, error) })
    }

//                .flatMap { productPage:ProductPage ->  Observable.just<ProductViewState>(ProductViewState.SearchResultState(page,productPage.products)) }
}