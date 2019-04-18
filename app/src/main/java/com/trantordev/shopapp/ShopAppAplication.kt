package com.trantordev.shopapp

import android.app.Application
import com.trantordev.shopapp.di.mainModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class ShopAppAplication: Application(){

    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
    }


    private fun setupKoin(){
        startKoin(this, listOf(mainModule))
    }

    private fun setupTimber(){
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}