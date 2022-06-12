package com.zm.pokemon.respository

import com.zm.pokemon.model.PokeMonDetails
import com.zm.pokemon.model.PokeMonList
import retrofit2.Response

interface INetworkRepository {

    suspend fun getPokeManList(): PokeMonList

    suspend fun getPokManDetails(id: String): PokeMonDetails
}