package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemOurServiceBinding
import com.example.cityfacility.ui.modelclass.OurServiceItem


class OurServiceAdapter () : RecyclerView.Adapter<OurServiceAdapter.OurServiceItemViewHolder>()  {

    private val ourServiceItem = mutableListOf<OurServiceItem>()
    inner class OurServiceItemViewHolder(val binding: ItemOurServiceBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OurServiceAdapter.OurServiceItemViewHolder {
        return OurServiceItemViewHolder(
            ItemOurServiceBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(
        holder: OurServiceAdapter.OurServiceItemViewHolder,
        position: Int
    ) {
        with(ourServiceItem[position]) {
            holder.binding.ivSubItem.setImageResource(image)
            holder.binding.tvDisinfection.text = text
        }
    }

    fun updateList(list: List<OurServiceItem>){
        ourServiceItem.clear()
        ourServiceItem.addAll(list)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return ourServiceItem.size
    }
}