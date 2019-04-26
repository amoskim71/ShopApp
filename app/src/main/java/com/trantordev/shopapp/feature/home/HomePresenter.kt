package com.trantordev.shopapp.feature.home

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class HomePresenter(private val homeInteractor: HomeInteractor) : MviBasePresenter<HomeView, HomeViewState>(HomeViewState.InitialState()) {


    override fun bindIntents() {
        val homeState: Observable<HomeViewState> = intent(HomeView::initList)
                .subscribeOn(Schedulers.io())
                .debounce(400, TimeUnit.MILLISECONDS)
                .switchMap { homeInteractor.initList(1) }
                .doOnNext { Timber.d("Received new state: " + it) }
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(homeState, HomeView::render)
    }
}