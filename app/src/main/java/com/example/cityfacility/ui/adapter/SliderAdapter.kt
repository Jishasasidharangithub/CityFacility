package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemSliderBinding
import com.example.cityfacility.ui.modelclass.SliderItem

class SliderAdapter(bannerList: ArrayList<SliderItem>) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {
    private val itemList = mutableListOf<SliderItem>()

    inner class SliderViewHolder(val binding: ItemSliderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return (SliderViewHolder(
            ItemSliderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ))
    }


    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        with(itemList[position])
        {
            holder.binding.ivSlide.setImageResource(image)

        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}