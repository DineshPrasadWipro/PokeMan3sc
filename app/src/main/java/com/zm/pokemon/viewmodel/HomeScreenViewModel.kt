package com.zm.pokemon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zm.pokemon.model.PokeMonList
import com.zm.pokemon.respository.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeScreenViewModel(private val networkRepository: NetworkRepository) : ViewModel() {
    private val _pokeMonList = MutableLiveData<PokeMonList>()
    val pokeMonList: LiveData<PokeMonList> get() = _pokeMonList
    val errorMessage = MutableLiveData<String>()

    val loading = MutableLiveData<Boolean>()

    fun getPokMonList() {
        loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val response = networkRepository.getPokManList()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    _pokeMonList.value = response.body()
                    loading.value = false
                } else {
                    onError(response.message())
                }

            }

        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }
}