package com.zm.pokemon

import androidx.lifecycle.MutableLiveData
import com.zm.pokemon.model.PokeMonDetails
import com.zm.pokemon.repository.mock.MockNetworkRepository
import com.zm.pokemon.respository.NetworkRepository
import com.zm.pokemon.viewmodel.PokMonDetailsViewModel
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.dsl.module

class PokMonDetailsViewModelTest : TestBase() {

    private val networkRepository: NetworkRepository = mockk(relaxed = true)
    private lateinit var mockNetworkRepository: MockNetworkRepository
    private lateinit var pokMonDetailsViewModel: PokMonDetailsViewModel

    private val pokeMondetails = MutableLiveData<PokeMonDetails>()


    override val koinModule = module {
        single<NetworkRepository>(override = true) { networkRepository }

    }

    @Before
    override fun setup() {
        super.setup()

        pokMonDetailsViewModel = PokMonDetailsViewModel(mockk())
        mockNetworkRepository = MockNetworkRepository()
    }

    @Test
    fun `test pokeMonDetails is updating properly`() {
        val actual = pokeMondetails

        mockNetworkRepository.setPokeManList()
        pokMonDetailsViewModel.pokeMonDetails.observeForever {
            pokeMondetails.value = it
        }
        runBlocking {
            mockNetworkRepository.getPokeManList()
        }
        Assert.assertNotEquals(actual, pokeMondetails.value)

    }

}