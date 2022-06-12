package com.zm.pokemon.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zm.pokemon.R
import com.zm.pokemon.adapter.PokeMonListAdapter
import com.zm.pokemon.model.PokeMonList
import com.zm.pokemon.viewmodel.HomeScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeScreenActivity : BaseActivity(),
    PokeMonListAdapter.ItemClickListener {

    private val homeScreenViewModel: HomeScreenViewModel by viewModel()
    private var adapter: PokeMonListAdapter? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        recyclerView = findViewById(R.id.pokemon_list)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        homeScreenViewModel.getPokMonList()

        homeScreenViewModel.pokeMonList.observe(this, Observer {
            setUpListView(it)
        })

        homeScreenViewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        homeScreenViewModel.loading.observe(this, Observer {
            if (it) {
                showProgress()
            } else {
                cancelProgress()
            }
        })
    }

    private fun setUpListView(pokeMonList: PokeMonList) {

        adapter = PokeMonListAdapter(pokeMonList, this)
        recyclerView?.adapter = adapter

    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, PokMonDetailsActivity::class.java)
        intent.apply {
            putExtra("id", (position + 1).toString())
            startActivity(intent)
        }
    }
}