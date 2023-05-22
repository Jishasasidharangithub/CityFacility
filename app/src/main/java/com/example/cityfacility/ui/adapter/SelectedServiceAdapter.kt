package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemSelectedServicesBinding
import com.example.cityfacility.ui.modelclass.SelectedServicesItem

class SelectedServiceAdapter () : RecyclerView.Adapter<SelectedServiceAdapter.SelectedServiceItemViewHolder>()  {

    private val selectedServiceItem = mutableListOf<SelectedServicesItem>()
    inner class SelectedServiceItemViewHolder(val binding: ItemSelectedServicesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectedServiceItemViewHolder {
        return SelectedServiceItemViewHolder(
            ItemSelectedServicesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    fun updateList(list: List<SelectedServicesItem>){
        selectedServiceItem.clear()
        selectedServiceItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SelectedServiceItemViewHolder, position: Int) {
        with(selectedServiceItem[position]) {
            holder.binding.tvSelectedServiceName.text = title
        }
    }

    override fun getItemCount(): Int {
        return selectedServiceItem.size
    }

}