package com.trantordev.shopapp.feature.home

import io.reactivex.Observable


class HomeInteractor {

    fun getContent(query: String): Observable<HomeViewState> {

        if(query.isEmpty()){
            return Observable.just<HomeViewState>(HomeViewState.MessageNotTypedYet())
        }

        var content = "Conteúdo 02"
        if(query.equals("1",true)){
            content = "Conteúdo 01"
        }

        return Observable.just<HomeViewState>(HomeViewState.MessageContent(content))

    }

    fun onButtonClick(): Observable<HomeViewState>{
        return Observable.just<HomeViewState>(HomeViewState.ButtonClicked())
    }

}