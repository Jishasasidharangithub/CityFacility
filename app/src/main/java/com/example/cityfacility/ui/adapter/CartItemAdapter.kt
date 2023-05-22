package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemCartBinding
import com.example.cityfacility.ui.modelclass.CartItem

class CartItemAdapter () : RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {

    private val cartItem = mutableListOf<CartItem>()
    inner class CartItemViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        return CartItemViewHolder(
            ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<CartItem>){
        cartItem.clear()
        cartItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        with(cartItem[position]) {
            holder.binding.tvACservices.text = title
            holder.binding.tvNumberofunits.text = description
            holder.binding.tvAED.text = aed
        }
    }

    override fun getItemCount(): Int {
        return cartItem.size
    }
}