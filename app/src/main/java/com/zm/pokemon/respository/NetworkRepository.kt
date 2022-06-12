package com.zm.pokemon.respository

import com.zm.pokemon.model.PokeMonDetails
import com.zm.pokemon.model.PokeMonList


class NetworkRepository(private val networkInterface: NetworkInterface) : INetworkRepository {


    override suspend fun getPokeManList(): PokeMonList {
        return networkInterface.getPokeManList().body() as PokeMonList
    }

    override suspend fun getPokManDetails(id: String): PokeMonDetails {

        return networkInterface.getPokManDetails(id).body() as PokeMonDetails
    }


}
