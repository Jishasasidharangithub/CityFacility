package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemWishListBinding
import com.example.cityfacility.ui.modelclass.WishListItem

class WishListItemAdapter() : RecyclerView.Adapter<WishListItemAdapter.WishListItemViewHolder>() {

    private val wishListItem = mutableListOf<WishListItem>()

    inner class WishListItemViewHolder(val binding: ItemWishListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishListItemViewHolder {
        return WishListItemViewHolder(
            ItemWishListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: WishListItemViewHolder, position: Int) {
        with(wishListItem[position]) {
            holder.binding.tvACservice.text = title
            holder.binding.tvAED200.text = aed
        }
    }

    fun updateList(list: List<WishListItem>){
        wishListItem.clear()
        wishListItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return wishListItem.size
    }
}