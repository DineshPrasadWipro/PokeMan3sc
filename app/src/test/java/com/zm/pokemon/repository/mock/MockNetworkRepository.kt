package com.zm.pokemon.repository.mock

import com.zm.pokemon.model.PokeMon
import com.zm.pokemon.model.PokeMonDetails
import com.zm.pokemon.model.PokeMonList
import com.zm.pokemon.respository.INetworkRepository
import io.mockk.mockk

class MockNetworkRepository() : INetworkRepository {

    var pokMonList: PokeMonList = mockk(relaxed = true)
    var pokMonDetails: PokeMonDetails = mockk(relaxed = true)
    private var pokeMon: ArrayList<PokeMon> = ArrayList<PokeMon>()
    override suspend fun getPokeManList(): PokeMonList {
        return pokMonList
    }

    override suspend fun getPokManDetails(id: String): PokeMonDetails {
        return pokMonDetails
    }

    fun setPokeManList() {
        for (i in 0..2) {
            pokeMon.add(PokeMon("", ""))
        }
        pokMonList = PokeMonList(1, "", "", pokeMon)
    }
}