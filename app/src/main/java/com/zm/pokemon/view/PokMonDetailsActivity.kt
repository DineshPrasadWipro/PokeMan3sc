package com.zm.pokemon.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.zm.pokemon.R
import com.zm.pokemon.model.PokeMonDetails
import com.zm.pokemon.viewmodel.PokMonDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokMonDetailsActivity : BaseActivity() {

    private val pockMonDetailsViewModel: PokMonDetailsViewModel by viewModel()
    private lateinit var pokMonName: TextView
    private lateinit var pokMonWeight: TextView
    private lateinit var pokMonHeight: TextView
    private lateinit var pokMonType: TextView
    private lateinit var pokMonImageView: ImageView

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
        pokMonName = findViewById(R.id.pokMonName)
        pokMonWeight = findViewById(R.id.pokMonWeight)
        pokMonHeight = findViewById(R.id.pokMonHeight)
        pokMonType = findViewById(R.id.pokMonType)
        pokMonImageView = findViewById(R.id.pokMonImage)

            id?.let { pockMonDetailsViewModel.getPokMonDetails(it) }

            pockMonDetailsViewModel.pokeMonDetails.observe(this, Observer {
                setData(it)
            })
        }

    private fun setData(pokeMonDetails: PokeMonDetails) {

        pokMonName.text = pokeMonDetails.name
        pokMonWeight.text = "Weight: " + pokeMonDetails.weight
        pokMonHeight.text = "Height: " + pokeMonDetails.height
        pokMonType.text = pokeMonDetails.types[0].type.toString()
        Glide.with(this)
            .load(pokeMonDetails.sprites.front_default)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(pokMonImageView)

    }
}