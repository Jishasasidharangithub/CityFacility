package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemMyPaymentBinding
import com.example.cityfacility.ui.modelclass.PaymentItem

class PaymentItemAdapter () : RecyclerView.Adapter<PaymentItemAdapter.PaymentItemViewHolder>()  {

    private val paymentItem = mutableListOf<PaymentItem>()
    inner class PaymentItemViewHolder(val binding: ItemMyPaymentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentItemViewHolder {
        return PaymentItemViewHolder(
            ItemMyPaymentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: PaymentItemViewHolder, position: Int) {
        with(paymentItem[position]) {
            holder.binding.tvPayment.text = title
            holder.binding.tvPaymentDate.text = date
            holder.binding.tvPaymentType.text = description
            holder.binding.tvAED.text = aed
        }
    }

    fun updateList(list: List<PaymentItem>){
        paymentItem.clear()
        paymentItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return paymentItem.size
    }
}