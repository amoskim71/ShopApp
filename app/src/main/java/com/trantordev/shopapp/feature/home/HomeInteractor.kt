package com.trantordev.shopapp.feature.home

import io.reactivex.Observable


class HomeInteractor {

    fun initList(page: Int): Observable<HomeViewState> {
        // Empty String, so no search
        return Observable.just<HomeViewState>(HomeViewState.InitialState())
    }

}