package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemMaintenancePackageBinding
import com.example.cityfacility.ui.modelclass.MaintenanceItem

class MaintenanceItemAdapter () : RecyclerView.Adapter<MaintenanceItemAdapter.MaintenanceItemViewHolder>() {

    private val maintenanceItem = mutableListOf<MaintenanceItem>()
    inner class MaintenanceItemViewHolder(val binding: ItemMaintenancePackageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaintenanceItemViewHolder {
        return MaintenanceItemViewHolder(
            ItemMaintenancePackageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MaintenanceItemViewHolder, position: Int) {
        with(maintenanceItem[position]) {
            holder.binding.tvBasic1.text = title
            holder.binding.tvAED.text = aed
        }
    }

    fun updateList(list: List<MaintenanceItem>){
        maintenanceItem.clear()
        maintenanceItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return maintenanceItem.size
    }

}