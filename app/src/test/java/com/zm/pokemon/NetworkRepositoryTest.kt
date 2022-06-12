package com.zm.pokemon

import com.zm.pokemon.model.PokeMonDetails
import com.zm.pokemon.model.PokeMonList
import com.zm.pokemon.repository.mock.MockNetworkRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class NetworkRepositoryTest {

    private lateinit var mockNetworkRepository: MockNetworkRepository

    private var pokeMonList: PokeMonList = mockk(relaxed = true)
    var pokeMonDetails: PokeMonDetails = mockk(relaxed = true)

    @Before
    fun setUp() {
        mockNetworkRepository = mockk(relaxed = true)
    }

    @Test
    fun `Should return PokeMonList instance`() {
        every {
            runBlocking {
                mockNetworkRepository.getPokeManList()
            }
        } returns pokeMonList
    }

    @Test
    fun `Should return PokeMonDetails instance`() {
        every {
            runBlocking {
                mockNetworkRepository.getPokManDetails("")
            }

        } returns pokeMonDetails

    }
}