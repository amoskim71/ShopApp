package com.trantordev.shopapp.feature.email

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EmailViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is email Fragment"
    }
    val text: LiveData<String> = _text
}