package com.trantordev.shopapp.feature.product.list

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface ProductView: MvpView {

    fun searchIntent(): Observable<Int>

    abstract fun render(viewState: ProductViewState)
}