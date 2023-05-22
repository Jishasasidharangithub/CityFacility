package com.example.cityfacility.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemCouponsBinding
import com.example.cityfacility.ui.modelclass.CouponsItem

class CouponsItemAdapter () : RecyclerView.Adapter<CouponsItemAdapter.CouponsViewHolder> () {

    private val couponsItem = mutableListOf<CouponsItem>()
    inner class CouponsViewHolder(val binding: ItemCouponsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponsViewHolder {
        return CouponsViewHolder(
            ItemCouponsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    fun updateList(list: List<CouponsItem>){
        couponsItem.clear()
        couponsItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CouponsViewHolder, position: Int) {
        with(couponsItem[position]) {
            holder.binding.tvFlat.text = title
            holder.binding.tvCouponsNumber.text = number
        }
    }
    override fun getItemCount(): Int {
        return couponsItem.size
    }

}