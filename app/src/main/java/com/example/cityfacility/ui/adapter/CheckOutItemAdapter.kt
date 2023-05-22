package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemCheckOutBinding
import com.example.cityfacility.ui.modelclass.CheckOutItem

class CheckOutItemAdapter () : RecyclerView.Adapter<CheckOutItemAdapter.CheckOutViewHolder>() {

    private val checkoutItem = mutableListOf<CheckOutItem>()
    inner class CheckOutViewHolder(val binding: ItemCheckOutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckOutViewHolder {
        return CheckOutViewHolder(
            ItemCheckOutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<CheckOutItem>){
        checkoutItem.clear()
        checkoutItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CheckOutViewHolder, position: Int) {
        with(checkoutItem[position]) {
            holder.binding.tvACservices.text = title
            holder.binding.tvNumberofunits.text = description
            holder.binding.tvAED.text = aed
        }
    }

    override fun getItemCount(): Int {
        return checkoutItem.size
    }

}