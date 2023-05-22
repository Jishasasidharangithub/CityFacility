package com.example.cityfacility.ui.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.R
import com.example.cityfacility.databinding.ItemLocationBinding
import com.example.cityfacility.ui.modelclass.LocationItem

class LocationAdapter() : RecyclerView.Adapter<LocationAdapter.LocationItemViewHolder>() {

    private val locationItem = mutableListOf<LocationItem>()
    var selectedPosition = 0

    inner class LocationItemViewHolder(val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationItemViewHolder {
        return LocationItemViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<LocationItem>) {
        locationItem.clear()
        locationItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: LocationItemViewHolder, position: Int) {
        with(locationItem[position]) {
            holder.binding.tvLocationName.text = title
            if (position == selectedPosition) {
                holder.binding.tvLocationName.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.white
                    )
                )
                holder.itemView.backgroundTintList =
                    ColorStateList.valueOf(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.green
                        )
                    )
            } else {
                holder.binding.tvLocationName.setTextColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        R.color.blue
                    )
                )
                holder.itemView.backgroundTintList =
                    ColorStateList.valueOf(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.white
                        )
                    )
            }
            holder.itemView.setOnClickListener {
                selectedPosition = position
                notifyDataSetChanged()
            }
        }


    }

    override fun getItemCount(): Int {
        return locationItem.size
    }


}