package com.zm.pokemon

import android.app.Application
import com.zm.pokemon.injection.appModule
import com.zm.pokemon.injection.repositoryModule
import com.zm.pokemon.injection.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokemonApplication : Application() {

    private val appModules = listOf(
        repositoryModule,
        appModule,
        vmModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokemonApplication)
            modules(appModules)
        }
    }
}


