package com.zm.pokemon.injection

import com.zm.pokemon.respository.INetworkRepository
import com.zm.pokemon.respository.NetworkRepository
import org.koin.dsl.module


val repositoryModule = module {
    single {
        NetworkRepository(get())
    }
}
