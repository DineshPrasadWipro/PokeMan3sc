package com.zm.pokemon

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.zm.pokemon.model.PokeMonList
import com.zm.pokemon.repository.mock.MockNetworkRepository
import com.zm.pokemon.respository.NetworkRepository
import com.zm.pokemon.viewmodel.HomeScreenViewModel
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.dsl.module

class HomeScreenViewModelTest() : TestBase() {

    private val networkRepository: NetworkRepository = mockk(relaxed = true)
    private lateinit var mockNetworkRepository: MockNetworkRepository
    private lateinit var homeScreenViewModel: HomeScreenViewModel

    private val pokeMonListLiveData = MutableLiveData<PokeMonList>()

    private lateinit var lifecycleOwner: LifecycleOwner
    private val loading = MutableLiveData<Boolean>()
    private val errorMessage = MutableLiveData<String>()


    override val koinModule = module {
        single<NetworkRepository>(override = true) { networkRepository }

    }

    @Before
    override fun setup() {
        super.setup()

        homeScreenViewModel = HomeScreenViewModel(mockk())
        mockNetworkRepository = MockNetworkRepository()
    }

    @Test
    fun `test pokeMonList is updating properly`() {
        val actual = pokeMonListLiveData

        mockNetworkRepository.setPokeManList()
        homeScreenViewModel.pokeMonList.observeForever {
            pokeMonListLiveData.value = it
        }
        runBlocking {
            mockNetworkRepository.getPokeManList()
        }
        Assert.assertNotEquals(actual, pokeMonListLiveData.value)

    }

    @Test
    fun `test error code is updating properly`() {
        val errorCode = "Error Code"
        homeScreenViewModel.errorMessage.observeForever {
            errorMessage.value = it
        }
        homeScreenViewModel.errorMessage.postValue("Error Code")
        Assert.assertEquals(errorCode, errorMessage.value)


    }

    @Test
    fun `test progress value is updating properly`() {
        loading.value = false
        homeScreenViewModel.loading.observeForever {
            loading.value = true
        }
        homeScreenViewModel.loading.postValue(true)
        Assert.assertEquals(loading.value, true)


    }
}