package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemSubRcvBinding
import com.example.cityfacility.ui.modelclass.SubServiceItem

class SubServiceAdapter () : RecyclerView.Adapter<SubServiceAdapter.SubServiceItemViewHolder>() {
    private val subItem = mutableListOf<SubServiceItem>()
    inner class SubServiceItemViewHolder(val binding: ItemSubRcvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubServiceAdapter.SubServiceItemViewHolder {
        return SubServiceItemViewHolder(
            ItemSubRcvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    fun updateList(list: List<SubServiceItem>){
        subItem.clear()
        subItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(
        holder: SubServiceAdapter.SubServiceItemViewHolder,
        position: Int
    ) {
        with(subItem[position]) {
            holder.binding.ivSubItem.setImageResource(image)
            holder.binding.tvDisinfection.text = text
        }
    }

    override fun getItemCount(): Int {
        return subItem.size
    }

}