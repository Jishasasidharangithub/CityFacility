package com.example.cityfacility.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityfacility.databinding.ItemNotificationBinding
import com.example.cityfacility.ui.modelclass.NotificationItem

class NotificationItemAdapter () : RecyclerView.Adapter<NotificationItemAdapter.NotificationItemViewHolder>() {

    private val notificationItem = mutableListOf<NotificationItem>()
    inner class NotificationItemViewHolder(val binding: ItemNotificationBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationItemViewHolder {
        return NotificationItemViewHolder(
            ItemNotificationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    fun updateList(list: List<NotificationItem>){
        notificationItem.clear()
        notificationItem.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: NotificationItemViewHolder, position: Int) {
        with(notificationItem[position]) {
            holder.binding.tvServiceDescription.text = description
            holder.binding.tvNotificationDate.text = date
        }
    }

    override fun getItemCount(): Int {
        return notificationItem.size
    }
}
