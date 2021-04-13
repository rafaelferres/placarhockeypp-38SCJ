package com.ghostapps.placapp.main

import android.app.Application
import org.koin.core.context.startKoin

class PlacApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
            )
        }

    }

}