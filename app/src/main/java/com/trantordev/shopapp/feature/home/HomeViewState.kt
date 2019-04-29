package com.trantordev.shopapp.feature.home

sealed class HomeViewState {
    class MessageNotTypedYetState: HomeViewState(){}

    class MessageContentState(val content: String): HomeViewState(){
        override fun toString():  String{
            return "RESULT_CONTENT: "+content;
        }
    }

    class ButtonClickedState: HomeViewState(){}

}