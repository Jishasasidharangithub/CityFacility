package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemBookingDetailsBinding
import com.example.cityfacility.ui.modelclass.BookingDetailItem

class BookingDetailItemAdapter () : RecyclerView.Adapter<BookingDetailItemAdapter.BookingDetailItemViewHolder>() {

    private val bookingDetailItem = mutableListOf<BookingDetailItem>()
    inner class BookingDetailItemViewHolder(val binding: ItemBookingDetailsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingDetailItemViewHolder {
        return BookingDetailItemViewHolder(
            ItemBookingDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateList(list: List<BookingDetailItem>){
        bookingDetailItem.clear()
        bookingDetailItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BookingDetailItemViewHolder, position: Int) {
        with(bookingDetailItem[position]) {
            holder.binding.tvACservices.text = title
            holder.binding.tvNumberofunits.text = description
            holder.binding.tvAED.text = aed
        }
    }

    override fun getItemCount(): Int {
        return bookingDetailItem.size
    }


}