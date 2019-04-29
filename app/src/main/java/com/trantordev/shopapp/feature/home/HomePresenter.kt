package com.trantordev.shopapp.feature.home

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class HomePresenter(private val homeInteractor: HomeInteractor) : MviBasePresenter<HomeView, HomeViewState>(HomeViewState.MessageNotTypedYet()) {


    override fun bindIntents() {
        val showMessage: Observable<HomeViewState> = intent(HomeView::showMessage)
                .subscribeOn(Schedulers.io())
                .debounce(400, TimeUnit.MILLISECONDS)
                .switchMap { query -> homeInteractor.getContent(query) }
                .doOnNext { Timber.d("VIEWSTATEREDER showmessage: " + it) }
                .observeOn(AndroidSchedulers.mainThread())

        val onButtonClick: Observable<HomeViewState> = intent(HomeView::onButtonClick)
                .subscribeOn(Schedulers.io())
                .switchMap { homeInteractor.onButtonClick() }
                .doOnNext {
                    Timber.d("VIEWSTATEREDER onButtonClick: " + it)
                }
                .observeOn(AndroidSchedulers.mainThread())

        val allIntentsObservable = Observable.merge(showMessage,onButtonClick)
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(allIntentsObservable, HomeView::render)

    }
}