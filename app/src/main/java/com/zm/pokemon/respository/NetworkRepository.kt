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
        try {
            apiInterface.getPokManDetails(id)
        } catch (e: Exception) {
            Log.d("Exception", e.toString())
        }
        return apiInterface.getPokManDetails(id)
    }
}
