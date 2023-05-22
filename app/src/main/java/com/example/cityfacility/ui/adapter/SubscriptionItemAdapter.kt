package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemMySubscriptionBinding
import com.example.cityfacility.ui.modelclass.SubscribedItem

class SubscriptionItemAdapter() :
    RecyclerView.Adapter<SubscriptionItemAdapter.SubscriptionItemViewHolder>() {

    private val subscriptionnItem = mutableListOf<SubscribedItem>()

    inner class SubscriptionItemViewHolder(val binding: ItemMySubscriptionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriptionItemViewHolder {
        return SubscriptionItemViewHolder(
            ItemMySubscriptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SubscriptionItemViewHolder, position: Int) {
        with(subscriptionnItem[position]) {
            holder.binding.tvBasic.text = title
            holder.binding.tvAED.text = aed
        }
    }

    fun updateList(list: List<SubscribedItem>){
        subscriptionnItem.clear()
        subscriptionnItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return subscriptionnItem.size
    }


}