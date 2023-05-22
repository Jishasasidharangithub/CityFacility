package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemOffersBinding
import com.example.cityfacility.ui.modelclass.OfferItem

class OfferItemAdapter () : RecyclerView.Adapter<OfferItemAdapter.OfferItemViewHolder>() {

    private val offerItem = mutableListOf<OfferItem>()
    inner class OfferItemViewHolder(val binding: ItemOffersBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferItemViewHolder {
        return OfferItemViewHolder(
            ItemOffersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<OfferItem>){
        offerItem.clear()
        offerItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: OfferItemViewHolder, position: Int) {
        with(offerItem[position]) {
            holder.binding.ivOffer.setImageResource(image)
        }
    }

    override fun getItemCount(): Int {
        return offerItem.size    }
}