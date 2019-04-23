package com.trantordev.shopapp.feature.product.list

import com.trantordev.shopapp.network.model.Products

sealed class ProductViewState {
    class InitialState: ProductViewState(){}
    class LoadingState : ProductViewState(){}

    class EmptyResultState() : ProductViewState() {

        override fun toString(): String {
            return "EmptyResult{emptyList}".toString()
        }
    }

    class ErrorState(val page: Int, val error: Throwable) : ProductViewState() {

        override fun toString(): String {
            return "Error{" +
                    "page='" + page + '\''.toString() +
                    ", error=" + error +
                    '}'.toString()
        }
    }

    class SearchResultState(val page: Int, val result: List<Products>) : ProductViewState() {

        override fun toString(): String {
            return "SearchResult{" +
                    "searchQueryText='" + page + '\''.toString() +
                    ", result=" + result +
                    '}'.toString()
        }
    }

}