package com.zm.pokemon.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zm.pokemon.model.PokeMonDetails
import com.zm.pokemon.respository.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokMonDetailsViewModel(private val networkRepository: NetworkRepository) : ViewModel() {

    private val _pokeMonDetails = MutableLiveData<PokeMonDetails>()
    val pokeMonDetails: LiveData<PokeMonDetails> get() = _pokeMonDetails

    fun getPokMonDetails(id: String) {
        viewModelScope.launch(Dispatchers.IO) {

            try {

                val response = networkRepository.getPokManDetails(id)

                withContext(Dispatchers.Main) {
                    response?.let {
                        _pokeMonDetails.value = it
                    }
                }

            } catch (exception: Exception) {
                Log.d("Details List", exception.message.toString())
            }
        }
    }


}