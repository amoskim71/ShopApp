package com.trantordev.shopapp.feature.home

sealed class HomeViewState {
    class MessageNotTypedYet: HomeViewState(){}

    class MessageContent(val content: String): HomeViewState(){
        override fun toString():  String{
            return "RESULT_CONTENT: "+content;
        }
    }

    class ButtonClicked: HomeViewState(){}

}