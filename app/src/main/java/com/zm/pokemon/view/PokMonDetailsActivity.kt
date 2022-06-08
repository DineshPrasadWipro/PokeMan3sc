package com.zm.pokemon.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.zm.pokemon.R
import com.zm.pokemon.model.PokMonDetails
import com.zm.pokemon.viewmodel.PokMonDetailsViewModel
import kotlinx.android.synthetic.main.activity_pok_mon_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokMonDetailsActivity : AppCompatActivity() {

    private val pockMonDetailsViewModel: PokMonDetailsViewModel by viewModel()
    var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pok_mon_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        intent?.let {
            id = it.getStringExtra("id")
        }
        init()
    }

    private fun init() {

        try {
            id?.let { pockMonDetailsViewModel.getPokMonDetails(it) }

            pockMonDetailsViewModel.pokeMonDetails.observe(this, Observer {
                setData(it)
            })
        } catch (e: Exception) {
            Log.d("Exception", e.toString())
        }

    }

    private fun setData(pokMonDetails: PokMonDetails) {

        pok_man_name.text = pokMonDetails.name
        pok_man_weight.text = "Weight: " + pokMonDetails.weight
        pok_man_height.text = "Height: " + pokMonDetails.height
        pok_man_type.text = pokMonDetails.types[0].type.toString()
        Glide.with(this)
            .load(pokMonDetails.sprites.front_default)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(pok_man_image)


    }
}