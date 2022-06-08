package com.zm.pokemon.model

import com.google.gson.annotations.SerializedName

data class PokMonDetails(
    //@SerializedName("abilities") val abilities: List<String>,
    @SerializedName("base_experience") val base_experience: String,
    // @SerializedName("forms") val forms: String,
    //@SerializedName("game_indices") val game_indices: List<PokeMon>,
    @SerializedName("height") val height: String,
    //@SerializedName("held_items") val held_items: String,
    @SerializedName("id") val id: String,
    @SerializedName("is_default") val is_default: String,
    @SerializedName("location_area_encounters") val location_area_encounters: String,
    // @SerializedName("moves") val moves: String,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: String,
    // @SerializedName("past_types") val past_types: String,
    //@SerializedName("species") val species: String,
    @SerializedName("sprites") val sprites: Sprites,
    //@SerializedName("stats") val stats: String,
    @SerializedName("types") val types: List<Types>,
    @SerializedName("weight") val weight: String,
)

