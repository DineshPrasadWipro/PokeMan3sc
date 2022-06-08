package com.zm.pokemon.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zm.pokemon.model.PokMonDetails
import com.zm.pokemon.respository.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokMonDetailsViewModel(private val networkRepository: NetworkRepository) : ViewModel() {

    private val _pokeMonDetails = MutableLiveData<PokMonDetails>()
    val pokeMonDetails: LiveData<PokMonDetails> get() = _pokeMonDetails

    fun getPokMonDetails(id: String) {
        viewModelScope.launch(Dispatchers.IO) {

            val response = networkRepository.getPokManDetails(id)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    _pokeMonDetails.value = response.body()
                    Log.e("Details List", response.body().toString())
                } else {
                    Log.e("response Fail", "response.body().toString()")
                }

            }

        }
    }


}