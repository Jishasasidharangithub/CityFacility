package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemAirConditioningBinding
import com.example.cityfacility.ui.modelclass.AirConditioningItem

class AirConditionItemAdapter () : RecyclerView.Adapter<AirConditionItemAdapter.AirConditionItemViewHolder>() {

    private val airConditionItem = mutableListOf<AirConditioningItem>()
    inner class AirConditionItemViewHolder(val binding: ItemAirConditioningBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirConditionItemViewHolder {
        return AirConditionItemViewHolder(
            ItemAirConditioningBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    fun updateList(list: List<AirConditioningItem>){
        airConditionItem.clear()
        airConditionItem.addAll(list)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: AirConditionItemViewHolder, position: Int) {
        with(airConditionItem[position]) {
            holder.binding.tvACService.text = title
            holder.binding.tvAED.text = aed
        }
    }
    override fun getItemCount(): Int {
        return airConditionItem.size
    }

}