package com.zm.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zm.pokemon.R
import com.zm.pokemon.model.PokeMon
import com.zm.pokemon.model.PokeMonList


class PokeMonListAdapter  constructor(
    pokeMonList: PokeMonList,
    clickListener: ItemClickListener
) :
    RecyclerView.Adapter<PokeMonListAdapter.ViewHolder>() {

    private var mData: List<PokeMon>
    private var mClickListener: ItemClickListener? = null

    init {
        mData = pokeMonList.results
        mClickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pokMonName.text = mData[position].name.capitalize()
        holder.lyt.setOnClickListener {
            mClickListener?.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var pokMonName: TextView
        var lyt: LinearLayout


        init {
            pokMonName = itemView.findViewById(R.id.pokMonName)
            lyt = itemView.findViewById(R.id.lyt)

        }
    }


     interface ItemClickListener {
        fun onItemClick(position: Int)
    }


}