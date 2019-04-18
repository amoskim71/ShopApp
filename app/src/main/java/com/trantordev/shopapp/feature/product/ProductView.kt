package com.trantordev.shopapp.feature.product

interface ProductView {

    abstract fun render(viewState: ProductViewState)
}