package com.rainaini.clubsepakbola

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext


//adapter untuk recyclerview
class AdapterBola(var list : MutableList<DataItem>, var listener : (DataItem) -> Unit) : RecyclerView.Adapter<AdapterBola.BolaViewHolder>() {

    //viewholder tidak menggunakan inflater tapi ankocontext
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BolaViewHolder {
        return BolaViewHolder(ClubSepakBolaUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: BolaViewHolder, position: Int) {
        holder.bindItem(list[position], listener)

    }

    inner class BolaViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        //UI Recyclerview ada di ClubSepakBolaUI

        private val logo = itemView.findViewById<ImageView>(ClubSepakBolaUI.gambar)
        private val club = itemView.findViewById<TextView>(ClubSepakBolaUI.namaclub)

        fun bindItem (items : DataItem, listener : (DataItem) -> Unit){
            club.text = items.namaclub
            Glide.with(itemView.context).load(items.gambar).into(logo)
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

}

