package com.zm.pokemon.respository

import android.util.Log
import com.zm.pokemon.model.PokMonDetails
import com.zm.pokemon.model.PokeMonList
import retrofit2.Response


class NetworkRepository(private val apiInterface: ApiInterface) {


    suspend fun getPokManList(): Response<PokeMonList> {

        return apiInterface.getPokManList()
    }

    suspend fun getPokManDetails(id: String): Response<PokMonDetails> {
      
        return apiInterface.getPokManDetails(id)
    }
}
