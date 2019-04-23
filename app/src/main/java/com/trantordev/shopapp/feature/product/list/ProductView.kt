package com.trantordev.shopapp.feature.product.list

interface ProductView {

    abstract fun render(viewState: ProductViewState)
}