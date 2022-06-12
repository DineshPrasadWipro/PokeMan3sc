package com.zm.pokemon.respository

import com.zm.pokemon.model.PokeMonDetails
import com.zm.pokemon.model.PokeMonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkInterface {
    @GET("pokemon")
    suspend fun getPokeManList(): Response<PokeMonList>

    @GET("pokemon/{id}")
    suspend fun getPokManDetails(@Path("id") id: String?): Response<PokeMonDetails>

}