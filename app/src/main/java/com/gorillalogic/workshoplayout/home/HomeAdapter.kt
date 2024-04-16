package com.gorillalogic.workshoplayout.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gorillalogic.workshoplayout.model.ItemModel
import com.gorillalogic.workshoplayout.R
import com.gorillalogic.workshoplayout.databinding.HomeItemBinding

class HomeAdapter(private val listener: (ItemModel) -> Unit) :
    ListAdapter<ItemModel, RecyclerView.ViewHolder>(HomeAdapterDiffCallback) {

    //region - View Holder
    class HomeItemViewHolder(private var binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root) {

        // Bind data with views
        fun bind(item: ItemModel, listener: (ItemModel) -> Unit) {
            binding.root.setOnClickListener { listener(item) }
            binding.homeItem = item
        }
    }
    //endregion

    //region - ListAdapter implementation
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeItemViewHolder(
            HomeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemData = getItem(position)
        (holder as HomeItemViewHolder).bind(itemData, listener)
    }
    //endregion

    //region - Companion DiffCallback implementation
    companion object HomeAdapterDiffCallback : DiffUtil.ItemCallback<ItemModel>() {

        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.imageResourceId == newItem.imageResourceId &&
                    oldItem.titleId == newItem.titleId &&
                    oldItem.descriptionId == newItem.descriptionId
        }

        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.imageResourceId == newItem.imageResourceId &&
                    oldItem.titleId == newItem.titleId &&
                    oldItem.descriptionId == newItem.descriptionId
        }
    }
    //endregion
}