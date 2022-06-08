package com.zm.pokemon.injection

import com.zm.pokemon.viewmodel.HomeScreenViewModel
import com.zm.pokemon.viewmodel.PokMonDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vmModule = module {

    viewModel {
        HomeScreenViewModel(get())
    }
    viewModel {
        PokMonDetailsViewModel(get())
    }
}


