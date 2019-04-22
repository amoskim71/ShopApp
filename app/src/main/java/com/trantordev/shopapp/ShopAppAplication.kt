package com.trantordev.shopapp

import android.app.Application
import com.trantordev.shopapp.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class ShopAppAplication: Application(){

    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
    }


    private fun setupKoin(){

        // TODO mantido por histórico
        //startKoin(this, listOf(mainModule))

        startKoin {

            androidLogger()

            androidContext(this@ShopAppAplication)

            modules(mainModule)

        }

    }

    private fun setupTimber(){
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}