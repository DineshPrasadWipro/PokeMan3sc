package com.zm.pokemon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zm.pokemon.model.PokeMonList
import com.zm.pokemon.respository.NetworkRepository
import kotlinx.coroutines.launch

class HomeScreenViewModel(private val networkRepository: NetworkRepository) : ViewModel() {
    private val _pokeMonList = MutableLiveData<PokeMonList>()
    val pokeMonList: LiveData<PokeMonList> get() = _pokeMonList

    val errorMessage = MutableLiveData<String>()

    val loading = MutableLiveData<Boolean>()

    fun getPokMonList() {
        loading.value = true


        viewModelScope.launch {
            try {
                val response = networkRepository.getPokeManList()

                response.let {
                    _pokeMonList.value = it
                    loading.value = false
                }
            } catch (exception: Exception) {
                onError(exception.message.toString())
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }
}