package com.zm.pokemon.respository

import com.zm.pokemon.model.PokMonDetails
import com.zm.pokemon.model.PokeMonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("pokemon")
    suspend fun getPokManList(): Response<PokeMonList>

    @GET("pokemon/{id}")
    suspend fun getPokManDetails(@Path("id") id: String?): Response<PokMonDetails>
}