package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemPackageBinding
import com.example.cityfacility.ui.modelclass.PackageItem


class PackageAdapter (private val listener: PackageAdapterListener) : RecyclerView.Adapter<PackageAdapter.PackageViewHolder> (){

    private val packageItem = mutableListOf<PackageItem>()
    inner class PackageViewHolder(val binding: ItemPackageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        return PackageViewHolder(
            ItemPackageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    fun updateList(list: List<PackageItem>){
        packageItem.clear()
        packageItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        with(packageItem[position]) {
            holder.binding.ivPackageItem.setImageResource(image)
            holder.binding.tvBasic.text = title
            holder.binding.tvAED.text = aed
            holder.binding.cvPackagercvItem.setOnClickListener {
                listener.viewMoreClick(this, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return packageItem.size
    }

    interface PackageAdapterListener {
        fun viewMoreClick(packageItem:PackageItem , pos: Int)
    }

}