package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemManageAddressBinding
import com.example.cityfacility.ui.modelclass.ManageItem

class ManageItemAdapter () : RecyclerView.Adapter<ManageItemAdapter.ManageItemViewHolder>() {

    private val manageItem = mutableListOf<ManageItem>()
    inner class ManageItemViewHolder(val binding: ItemManageAddressBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ManageItemAdapter.ManageItemViewHolder {
        return ManageItemViewHolder(
            ItemManageAddressBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    fun updateList(list: List<ManageItem>){
        manageItem.clear()
        manageItem.addAll(list)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ManageItemAdapter.ManageItemViewHolder, position: Int) {
        with(manageItem[position]) {
            holder.binding.tvAddress1.text = title
            holder.binding.tvUserName.text = username
            holder.binding.tvAddressDecription.text = address
        }
    }

    override fun getItemCount(): Int {
        return manageItem.size
    }

}