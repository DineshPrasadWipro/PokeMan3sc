package com.zm.pokemon.model

import com.google.gson.annotations.SerializedName

data class Sprites( //@SerializedName("abilities") val abilities: List<String>,
    @SerializedName("front_default") val front_default: String
)
