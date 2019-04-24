package com.trantordev.shopapp.feature.product.list

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.observable.ObservableReplay.observeOn
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class ProductPresenter(private val productInteractor: ProductInteractor) : MviBasePresenter<ProductView, ProductViewState>() {

//    override fun bindIntents() {
//        val search = intent(ViewIntentBinder<ProductView, Any> { ProductView.searchIntent() })
//                .doOnNext { s -> Timber.d("intent: Search '%s'", s) }
//                .switchMap(Function<Any, ObservableSource<*>> { productInteractor.search() })
//                .observeOn(AndroidSchedulers.mainThread())
//
//        subscribeViewState(search) { ProductView.render() }
//    }

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