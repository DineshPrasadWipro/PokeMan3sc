package com.zm.pokemon.model

import com.google.gson.annotations.SerializedName

data class PokeMonDetails(

    @SerializedName("base_experience") val base_experience: String,

    @SerializedName("height") val height: String,

    @SerializedName("id") val id: String,
    @SerializedName("is_default") val is_default: String,
    @SerializedName("location_area_encounters") val location_area_encounters: String,

    @SerializedName("name") val name: String,
    @SerializedName("order") val order: String,

    @SerializedName("sprites") val sprites: Sprites,

    @SerializedName("types") val types: List<Types>,
    @SerializedName("weight") val weight: String,
)

