package com.zm.pokemon.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zm.pokemon.R
import com.zm.pokemon.adapter.PokeMonListAdapter
import com.zm.pokemon.model.PokeMon
import com.zm.pokemon.viewmodel.HomeScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class HomeScreenActivity : BaseActivity(),
    PokeMonListAdapter.ItemClickListener {

    private val homeScreenViewModel: HomeScreenViewModel by viewModel()
    private var adapter: PokeMonListAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var mPokeMonList: List<PokeMon>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        recyclerView = findViewById(R.id.pokemon_list)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        homeScreenViewModel.getPokMonList()

        homeScreenViewModel.pokeMonList.observe(this) {
            setUpListView(it.results)
        }

        homeScreenViewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        homeScreenViewModel.loading.observe(this) {
            if (it) {
                showProgress()
            } else {
                cancelProgress()
            }
        }
    }

    private fun setUpListView(pokeMonList: List<PokeMon>) {
        adapter = PokeMonListAdapter(pokeMonList, this)
        recyclerView?.adapter = adapter
        mPokeMonList = pokeMonList

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater

        inflater.inflate(R.menu.search_menu, menu)

        val searchItem = menu.findItem(R.id.actionSearch)

        val searchView: SearchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText!!)
                return false
            }
        })
        return true
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, PokMonDetailsActivity::class.java)
        intent.apply {
            putExtra("id", (position + 1).toString())
            startActivity(intent)
        }
    }

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredList = ArrayList<PokeMon>()

        // running a for loop to compare elements.
        for (item in mPokeMonList!!) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.name.contains(text)) {
                filteredList.add(item)
            }
        }
        if (filteredList.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter?.filterList(filteredList)
        }
    }
}