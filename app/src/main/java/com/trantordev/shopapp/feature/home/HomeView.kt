package com.trantordev.shopapp.feature.home

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.trantordev.shopapp.feature.product.list.ProductViewState
import io.reactivex.Observable

interface HomeView: MvpView {

    fun showMessage(): Observable<String>

    fun onButtonClick(): Observable<Unit>

    abstract fun render(viewState: HomeViewState)
}