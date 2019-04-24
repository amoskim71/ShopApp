package com.trantordev.shopapp.feature.product.list

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.observable.ObservableReplay.observeOn
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class ProductPresenter(private val productInteractor: ProductInteractor) : MviBasePresenter<ProductView, ProductViewState>(ProductViewState.InitialState()) {


    override fun bindIntents() {
        val productState: Observable<ProductViewState> = intent(ProductView::searchIntent)
                .subscribeOn(Schedulers.io())
                .debounce(400, TimeUnit.MILLISECONDS)
                .switchMap { productInteractor.search(1) }
                .doOnNext { Timber.d("Received new state: " + it) }
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(productState, ProductView::render)
    }
}