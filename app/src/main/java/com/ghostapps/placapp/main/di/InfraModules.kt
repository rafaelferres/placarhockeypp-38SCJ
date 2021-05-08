package com.ghostapps.placapp.main.di

import com.ghostapps.placapp.infra.http.HttpAdapter
import org.koin.dsl.module
import com.google.firebase.auth.FirebaseAuth

object InfraModules {
    val modules = module {
        factory {
            HttpAdapter()
        }
        factory { FirebaseAuth.getInstance() }
    }
}