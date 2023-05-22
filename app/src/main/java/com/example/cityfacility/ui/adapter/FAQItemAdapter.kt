package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemFaqBinding
import com.example.cityfacility.ui.modelclass.FAQItem

class FAQItemAdapter () : RecyclerView.Adapter<FAQItemAdapter.FAQItemViewHolder>() {

    private val faqItem = mutableListOf<FAQItem>()
    inner class FAQItemViewHolder(val binding: ItemFaqBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQItemViewHolder {
        return FAQItemViewHolder(
            ItemFaqBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: FAQItemViewHolder, position: Int) {
        with(faqItem[position]) {
            holder.binding.tvFAQTitle1.text = title1
            holder.binding.tvFAQTitle2.text = title2
            holder.binding.tvFAQDescription.text = discription
        }
    }

    fun updateList(list: List<FAQItem>){
        faqItem.clear()
        faqItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return faqItem.size
    }
}