package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemMyBookingBinding
import com.example.cityfacility.ui.modelclass.BookingItem

class BookingItemAdapter () : RecyclerView.Adapter<BookingItemAdapter.BookingItemViewHolder>() {

    private val bookingItem = mutableListOf<BookingItem>()
    inner class BookingItemViewHolder(val binding: ItemMyBookingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingItemViewHolder {
        return BookingItemViewHolder(
            ItemMyBookingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    fun updateList(list: List<BookingItem>){
        bookingItem.clear()
        bookingItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BookingItemViewHolder, position: Int) {
        with(bookingItem[position]) {
            holder.binding.tvBookingId.text = number
            holder.binding.tvBookingDate.text = date
            holder.binding.tvBookingStatus.text = status
            holder.binding.tvBookingTime.text = time
        }
    }

    override fun getItemCount(): Int {
        return bookingItem.size
    }

}