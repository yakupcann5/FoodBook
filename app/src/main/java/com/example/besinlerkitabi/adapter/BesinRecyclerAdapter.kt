package com.example.besinlerkitabi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.besinlerkitabi.R
import com.example.besinlerkitabi.adapter.BesinRecyclerAdapter.*
import com.example.besinlerkitabi.databinding.BesinRecyclerRowBinding
import com.example.besinlerkitabi.fragment.BesinListesiFragmentDirections
import com.example.besinlerkitabi.model.Besin
import com.example.besinlerkitabi.util.gorselIndir
import com.example.besinlerkitabi.util.placeholderYap
import kotlinx.android.synthetic.main.besin_recycler_row.view.*

class BesinRecyclerAdapter (val besinListesi : ArrayList<Besin>) : RecyclerView.Adapter<BesinViewHolder>() {
    class BesinViewHolder(itemView:BesinRecyclerRowBinding): RecyclerView.ViewHolder(itemView.root){

        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.besin_recycler_row,parent,false)
        val view = DataBindingUtil.inflate<BesinRecyclerRowBinding>(inflater,R.layout.besin_recycler_row,parent,false)
        return  BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        holder.itemView.besin.text=besinListesi.get(position).besinIsim
        holder.itemView.kalorisi.text=besinListesi.get(position).besinKalori

        holder.itemView.setOnClickListener {
            val action = BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayFragment(besinListesi.get(position).uuid)
            Navigation.findNavController(it).navigate(action)
        }
        holder.itemView.imageView.gorselIndir(besinListesi.get(position).besinGorsel, placeholderYap(holder.itemView.context))


    }

    override fun getItemCount(): Int {
        return besinListesi.size
    }
    fun besinListesiniGuncelle(yeniBesinListesi:List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()

    }
}